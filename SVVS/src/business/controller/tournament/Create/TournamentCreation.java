/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import business.controller.RMI.AController;
import business.controller.tournament.Create.States.ITournamentCreateState;
import business.controller.tournament.Create.States.TournamentCreateLoadSportState;
import business.controller.tournament.TournamentController;
import data.DAOs.LeagueDAO;
import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.DTOs.TeamDTO;
import data.DTOs.TournamentDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ILeague;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.models.Sport;
import data.models.Tournament;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;

/**
 * Context für den Use Case neues Tournament, GUI sollte interface von dem
 * kriegen
 *
 * First LoadSport Second LoadTeams Third CreateTournament
 *
 * @author phil
 */
public class TournamentCreation extends AController implements ITournamentCreation {

    ITournamentCreateState _curState;

    public ITournamentCreateState getCurState() {
        return _curState;
    }

    public void setCurState(ITournamentCreateState curState) {
        this._curState = curState;
    }

    public TournamentCreation() throws RemoteException {
        super();
        setCurState(new TournamentCreateLoadSportState(this));
    }

    @Override
    public LinkedList<ISportDTO> loadSport(List<IDepartmentDTO> department) throws RemoteException {
        //return _curState.loadSport();
        return TournamentController.getInstance().loadSport(department);
    }

    @Override
    public LinkedList<ITeamDTO> loadTeams(String sport) throws RemoteException {
        //return _curState.loadTeams(sport);
        return TournamentController.getInstance().loadTeams(sport);
    }
    
    public LinkedList<ILeagueDTO> loadLeagues() throws RemoteException {
        return new LinkedList<>(LeagueDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession()));
    }

    @Override
    public LinkedList<ITeamDTO> loadTeamsWithLeague(String leaguename) throws RemoteException {
        LinkedList<ITeamDTO> teams = new LinkedList<>();
        for (ITeam it : TeamDAO.getInstance().getByLeague(HibernateUtil.getCurrentSession(), getLeagueWithName(leaguename))) {
            teams.add(new TeamDTO(it));
        }
        return teams;
    }

    @Override
    public LinkedList<ITeamDTO> loadTeamsBySportAndLeague(String sportname, String leaguename) throws RemoteException {
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);
        LinkedList<ITeamDTO> teams = new LinkedList<>();
        for (ITeam it : TeamDAO.getInstance().getBySportAndLeague(HibernateUtil.getCurrentSession(), sport, getLeagueWithName(leaguename))) {
            teams.add(new TeamDTO(it));
        }
        return teams;
    }

    @Override
    public ILeague getLeagueWithName(String leaguename) throws RemoteException {
        List<ILeague> league = LeagueDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        for (ILeague iL : league) {
            if (iL.getName().equals(leaguename)) {
                return iL;
            }
        }
        return null;
    }

    @Override
    public ITournamentDTO CreateTournament(String name, String location, String date, BigDecimal fee, String sportname, List<String> TeamNames) throws RemoteException {
        //_curState.CreateTournament(name, location, fee, sportname, TeamNames);

        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();

        Tournament tournament = new Tournament();
        tournament.setName(name);
        tournament.setDate(Date.valueOf(date));
        tournament.setLocation(location);
        tournament.setFee(fee);
        ISport sport = SportDAO.getInstance().getByName(s, sportname);
        tournament.setSport(sport);
        
        LinkedList<ITeam> teams = new LinkedList<ITeam>();
        //für jedes  team in der stringliste werden alle teams durchgegangen ob der name darin vorhanden ist
        for (String team : TeamNames) {
            for (ITeam it : TeamDAO.getInstance().getBySport(s, sport)) {
                if (it.getName().equals(team)) {
                    teams.add(it);
                }
            }
        }

        tournament.setTeams(teams);

        ITournamentDTO tournamentDTO = new TournamentDTO(tournament);
        TournamentDAO.getInstance().add(s, tournament);

        tx.commit();

        return tournamentDTO;
    }
}
