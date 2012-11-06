/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team;

import business.controller.RMI.AController;
import data.DAOs.LeagueDAO;
import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentTeamDAO;
import data.DAOs.TrainingTeamDAO;
import data.DTOs.SportsmanTrainingTeamDTO;
import data.DTOs.TeamDTO;
import data.DTOs.TournamentTeamDTO;
import data.DTOs.TrainingTeamDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITournamentTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ILeague;
import data.interfaces.models.ISport;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournamentTeam;
import data.interfaces.models.ITrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import org.hibernate.Hibernate;

/**
 *
 * @author phil
 */
public class TeamController extends AController implements ITeamController {

    private static TeamController instance;

    private TeamController() throws RemoteException {
        super();
    }

    public static TeamController getInstance() throws RemoteException {
        if (instance == null) {
            return (instance = new TeamController());
        }
        return instance;
    }

    public LinkedList<ITeamDTO> loadTeams() throws RemoteException {
        return new LinkedList<ITeamDTO>(TeamDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession()));
    }

    public LinkedList<ITeamDTO> loadTeams(String sportname)  throws RemoteException{
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);
        LinkedList<ITeamDTO> teams = new LinkedList<ITeamDTO>();
        for (ITeam it : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
            teams.add(new TeamDTO(it));
        }
        return teams;
    }
    
    public  LinkedList<ITeamDTO> loadTeamsWithLeague(String leaguename) throws RemoteException{
         LinkedList<ITeamDTO> teams = new LinkedList<ITeamDTO>();
        for (ITeam it : TeamDAO.getInstance().getByLeague(HibernateUtil.getCurrentSession(), getLeagueWithName(leaguename))) {
            teams.add(new TeamDTO(it));
        }
        return teams;
    }
    
    public LinkedList<ITeamDTO> loadTeams(String sportname, String leaguename) throws RemoteException {
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);
        LinkedList<ITeamDTO> teams = new LinkedList<ITeamDTO>();
        for (ITeam it : TeamDAO.getInstance().getBySportAndLeague(HibernateUtil.getCurrentSession(), sport, getLeagueWithName(leaguename))) {
            teams.add(new TeamDTO(it));
        }
        return teams;
    }
    
    private ILeague getLeagueWithName(String leaguename) throws RemoteException{
    List<ILeague> league = LeagueDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        for (ILeague iL : league) {
            if (iL.getName().equals(leaguename)) {
                return iL;
            }
        }
        return null;
    }

    @Override
    public LinkedList<ITournamentTeamDTO> loadTounamentTeams() throws RemoteException {
        return new LinkedList<ITournamentTeamDTO>(TournamentTeamDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession()));
    }

    @Override
    public LinkedList<ITournamentTeamDTO> loadTounamentTeams(String sportname) throws RemoteException {
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);
        LinkedList<ITournamentTeamDTO> teams = new LinkedList<ITournamentTeamDTO>();
        for (ITournamentTeam it : TournamentTeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
            teams.add(new TournamentTeamDTO(it));
        }
        return teams;
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTrainingTeams() throws RemoteException {
        return new LinkedList<ITrainingTeamDTO>(TrainingTeamDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession()));
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTrainingTeams(String sportname) throws RemoteException {
        LinkedList<ITrainingTeamDTO> teams = new LinkedList<ITrainingTeamDTO>();
        for (ITrainingTeam iT : TrainingTeamDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (iT.getName().equals(sportname)) {
                teams.add(new TrainingTeamDTO(iT));
            }
        }
        return teams;
    }

    @Override
    public LinkedList<ISportsmanTrainingTeamDTO> loadPlayersOfTeam(String TeamName) throws RemoteException {
        ITrainingTeam iteam = TrainingTeamDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), TeamName);
        
        if(iteam == null) {
            return null;
        }
        
        List<ISportsmanTrainingTeam> stt = iteam.getSportsmen();
        LinkedList<ISportsmanTrainingTeamDTO> sportsman = new LinkedList<ISportsmanTrainingTeamDTO>();
        for (ISportsmanTrainingTeam iSpTT : stt) {
            sportsman.add(new SportsmanTrainingTeamDTO(iSpTT));
        }
        return sportsman;
    }
}
