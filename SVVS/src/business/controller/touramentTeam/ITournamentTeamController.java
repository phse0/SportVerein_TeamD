/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.touramentTeam;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ITournamentTeamController extends Remote, IController{
    
    public List<ITournamentInviteDTO> loadTournamentTeams() throws RemoteException;
    
    public List<ISportsmanDTO> loadPlayersOfTeam(ITournamentDTO tournament, ITrainingTeamDTO team) throws RemoteException;

    public List<ISportsmanDTO> loadNotAssignedPlayersOfTeam(ITournamentDTO tournament, ITrainingTeamDTO team)throws RemoteException;
    
    public void assignPlayer(ITournamentDTO tournament, ITrainingTeamDTO team, ISportsmanDTO sportsman) throws RemoteException;
    
}
