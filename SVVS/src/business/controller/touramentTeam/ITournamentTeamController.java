/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.touramentTeam;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.models.ITrainingTeam;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author uubu
 */
public interface ITournamentTeamController extends Remote, IController{
    
    public LinkedList<ITournamentInviteDTO> loadTournamentTeams() throws RemoteException;
    
    public LinkedList<ISportsmanDTO> loadPlayersOfTeam(ITournamentDTO tournament, ITrainingTeam team) throws RemoteException;

    public LinkedList<ISportsmanDTO> loadNotAssignedPlayersOfTeam(ITournamentDTO tournament, ITrainingTeam team)throws RemoteException;
    
    public void assignPlayers(ITournamentDTO tournament, ITrainingTeam team, ISportsmanDTO sportsman) throws RemoteException;
    
}
