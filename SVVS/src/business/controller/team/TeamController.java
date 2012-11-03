/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team;

import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TrainingTeamDAO;
import data.DTOs.TeamDTO;
import data.DTOs.TrainingTeamDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class TeamController implements ITeamController{

     private static TeamController instance;

    private TeamController() {
    }

    public static TeamController getInstance() {
        if (instance == null) {
            return (instance = new TeamController());
        }
        return instance;
    }
    
    @Override
    public LinkedList<ITeamDTO> loadTeams() throws RemoteException {
         return new LinkedList<ITeamDTO>(TeamDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession()));
    }

    @Override
    public LinkedList<ITeamDTO> loadTeams(String sportname) throws RemoteException {
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);
        LinkedList<ITeamDTO> teams = new LinkedList<ITeamDTO>();
        for (ITeam it : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
            teams.add(new TeamDTO(it));
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
    
}
