/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.playerToTeam;

import business.controller.RMI.AController;
import business.controller.team.TeamController;
import business.controller.team.playerToTeam.state.IPlayerToTeamState;
import business.controller.team.playerToTeam.state.PlayerToTeamTeamLoadState;
import data.DAOs.SportsmanDAO;
import data.DAOs.SportsmanTrainingTeamDAO;
import data.DAOs.TrainingTeamDAO;
import data.DTOs.SportsmanDTO;
import data.DTOs.SportsmanTrainingTeamDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITrainingTeam;
import data.models.SportsmanTrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * First loadTeam
 * Second LoadSportsman
 * Third AddPlayerToTeam
 * @author phil
 */
public class PlayerToTeam extends AController implements IPlayerToTeam{
    IPlayerToTeamState _state;

    public PlayerToTeam() throws RemoteException {
        super();
        setState(new PlayerToTeamTeamLoadState(this));
    }
    
    public void setState(IPlayerToTeamState state) {
        _state = state;
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTeam() throws RemoteException {
        return _state.loadTeam();
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTeams(String sportname) throws RemoteException {
        return _state.loadTeams(sportname);
    }

//    @Override
//    public LinkedList<ISportsmanDTO> loadSportsman(String sportname) throws RemoteException {
//        return  _state.loadSportsman(sportname);
//    }
    
    @Override
    public LinkedList<ISportsmanDTO> loadSportsman(String sportname, List<ISportsmanDTO> ignoreList) throws RemoteException {
         
        LinkedList<ISportsmanDTO> sportsmen = new LinkedList<ISportsmanDTO>();
        
        for (ISportsman iS : SportsmanDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (iS.getSport().getName().equals(sportname)) {
                sportsmen.add(new SportsmanDTO(iS));
            }
        }
        
        for(ISportsmanDTO dto : ignoreList){
            sportsmen.remove(dto);
        }
        //_context.setState(new PlayerToTeamState(_context));
        return sportsmen;
    }

    @Override
    public ISportsmanTrainingTeamDTO AddPlayerToTeam(int TrainingTeamID, int SportsmanID, String position) throws RemoteException {
        
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

        ISportsmanTrainingTeam sttModel = new SportsmanTrainingTeam(sm,t,position);
    
        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.getTransaction();
        tx.begin();
        SportsmanTrainingTeamDAO.getInstance().add(HibernateUtil.getCurrentSession(),sttModel );
        
        SportsmanTrainingTeamDTO addedPlayer = new SportsmanTrainingTeamDTO(sttModel);
        tx.commit();
        
        return addedPlayer;
        
    }
    
   
    @Override
    public void RemovePlayerFromTeam(ISportsmanTrainingTeamDTO dto) throws RemoteException {
        
        Session s = HibernateUtil.getCurrentSession();
        ISportsmanTrainingTeam sttModel = SportsmanTrainingTeamDAO.getInstance().getById(s, dto.getId());
        Transaction tx = s.getTransaction();
        
        tx.begin();
        SportsmanTrainingTeamDAO.getInstance().remove(HibernateUtil.getCurrentSession(),sttModel );
        tx.commit();  
    }

    @Override
    public LinkedList<ISportsmanTrainingTeamDTO> loadPlayersOfTeam(String TeamName) throws RemoteException {
        // _context.setState(new PlayerToTeamLoadSportmanState(_context));
        return TeamController.getInstance().loadPlayersOfTeam(TeamName);
    }

    
    
}
