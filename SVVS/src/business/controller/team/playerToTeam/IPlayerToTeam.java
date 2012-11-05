/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.playerToTeam;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsman;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * First loadTeam
 * Second LoadSportsman
 * Third AddPlayerToTeam
 * @author phil
 */
public interface IPlayerToTeam extends Remote, IController  {
  public LinkedList<ITrainingTeamDTO> loadTeam()  throws RemoteException;
  public LinkedList<ITrainingTeamDTO> loadTeams(String sportname) throws RemoteException;
  public LinkedList<ISportsmanTrainingTeamDTO> loadPlayersOfTeam(String TeamName) throws RemoteException;
  
  public LinkedList<ISportsmanDTO> loadSportsman(String sportname, List<ISportsmanDTO> ignoreList)throws RemoteException;
  
  public void AddPlayerToTeam(int TrainingTeamID, int SportsmanID, String position) throws RemoteException ;
}
