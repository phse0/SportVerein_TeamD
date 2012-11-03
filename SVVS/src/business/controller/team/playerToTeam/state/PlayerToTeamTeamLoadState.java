/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.playerToTeam.state;

import business.controller.team.playerToTeam.PlayerToTeam;
import data.DAOs.TrainingTeamDAO;
import data.DTOs.TrainingTeamDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ITrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class PlayerToTeamTeamLoadState implements IPlayerToTeamState {

    PlayerToTeam _context;

    public PlayerToTeamTeamLoadState(PlayerToTeam context) {
        this._context = context;
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTeam() throws RemoteException {
        _context.setState(new PlayerToTeamLoadSportmanState(_context));
        return new LinkedList<ITrainingTeamDTO>(TrainingTeamDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession()));
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTeams(String sportname) throws RemoteException {
        LinkedList<ITrainingTeamDTO> teams = new LinkedList<ITrainingTeamDTO>();
        for (ITrainingTeam iT : TrainingTeamDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (iT.getName().equals(sportname)) {
                teams.add(new TrainingTeamDTO(iT));
            }
        }
        _context.setState(new PlayerToTeamLoadSportmanState(_context));
        return teams;
    }

    @Override
    public void AddPlayerToTeam(int TrainingTeamID, int SportsmanID, String position) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISportsmanDTO> loadSportsman(String sportname) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
