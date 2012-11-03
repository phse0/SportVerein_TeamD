/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.playerToTeam.state;

import business.controller.team.playerToTeam.IPlayerToTeam;
import data.DAOs.SportsmanDAO;
import data.DAOs.SportsmanTrainingTeamDAO;
import data.DAOs.TrainingTeamDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ITrainingTeam;
import data.models.SportsmanTrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
class PlayerToTeamState implements IPlayerToTeamState {

    IPlayerToTeam _context;

    public PlayerToTeamState(IPlayerToTeam context) {
        _context = context;
    }

    
    @Override
    public LinkedList<ITrainingTeamDTO> loadTeam() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTeams(String sportname) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISportsmanDTO> loadSportsman(String sportname) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AddPlayerToTeam(int TrainingTeamID, int SportsmanID, String position) throws RemoteException {
        ISportsman sm = null;
        ITrainingTeam t = null;
        for (ISportsman iS : SportsmanDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (iS.getRoleID() == SportsmanID) {
                sm = iS;
            }
        }
        
        
        
        for(ITrainingTeam iT : TrainingTeamDAO.getInstance().getAll(HibernateUtil.getCurrentSession())){
            if (iT.getTeamID() == TrainingTeamID) {
                t = iT;
            }
        }

        SportsmanTrainingTeamDAO.getInstance().add(HibernateUtil.getCurrentSession(), new SportsmanTrainingTeam(sm,t,position));
        
    }

}
