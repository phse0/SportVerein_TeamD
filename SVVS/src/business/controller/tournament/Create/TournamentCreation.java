/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import business.controller.tournament.Create.States.ITournamentCreateState;
import business.controller.tournament.Create.States.TournamentCreateLoadSportState;
import business.controller.tournament.TournamentController;
import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.models.Tournament;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * Context für den Use Case neues Tournament, GUI sollte interface von dem
 * kriegen
 *
 * First LoadSport
 * Second LoadTeams
 * Third CreateTournament
 * @author phil
 */
public class TournamentCreation  extends UnicastRemoteObject implements ITournamentCreation {

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
    public LinkedList<ISportDTO> loadSport() throws RemoteException {
        //return _curState.loadSport();
        return TournamentController.getInstance().loadSport();
    }
    
    @Override
    public LinkedList<ITeamDTO> loadTeams(String sport) throws RemoteException {
        //return _curState.loadTeams(sport);
        return TournamentController.getInstance().loadTeams(sport);
    }
    
    @Override
    public void CreateTournament(String name, String location, BigDecimal fee, String sportname, List<String> TeamNames) throws RemoteException {
        //_curState.CreateTournament(name, location, fee, sportname, TeamNames);
         Tournament tournament = new Tournament();
        tournament.setName(name);
        tournament.setLocation(location);
        tournament.setFee(fee);
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);

        LinkedList<ITeam> teams = new LinkedList<ITeam>();
        //für jedes  team in der stringliste werden alle teams durchgegangen ob der name darin vorhanden ist
        for (String team : TeamNames) {
            for (ITeam it : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
                if (it.getName().equals(team)) {
                    teams.add(it);
                }
            }
        }

        tournament.setTeams(teams);

        TournamentDAO.getInstance().add(HibernateUtil.getCurrentSession(), tournament);
    }
}
