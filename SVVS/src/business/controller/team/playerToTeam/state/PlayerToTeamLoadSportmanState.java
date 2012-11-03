/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.playerToTeam.state;

import business.controller.team.playerToTeam.PlayerToTeam;
import data.DAOs.SportsmanDAO;
import data.DTOs.SportsmanDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsman;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
class PlayerToTeamLoadSportmanState implements IPlayerToTeamState {
    PlayerToTeam _context;
    public PlayerToTeamLoadSportmanState(PlayerToTeam context) {
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
        LinkedList<ISportsmanDTO> sportsmen = new LinkedList<ISportsmanDTO>();
        for (ISportsman iS : SportsmanDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (iS.getSport().getName().equals(sportname)) {
                sportsmen.add(new SportsmanDTO(iS));
            }
        }
        _context.setState(new PlayerToTeamState(_context));
        return sportsmen;
    }

    @Override
    public void AddPlayerToTeam(int TrainingTeamID, int SportsmanID, String position) throws RemoteException  {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
