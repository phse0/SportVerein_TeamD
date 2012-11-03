/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team;

import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DTOs.TeamDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
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
    
}
