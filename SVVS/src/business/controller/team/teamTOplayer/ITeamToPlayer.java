/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.teamTOplayer;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public interface ITeamToPlayer extends Remote, IController {
    public LinkedList<ITrainingTeamDTO> loadTrainingTeams() throws RemoteException;
    public LinkedList<ITrainingTeamDTO> loadTrainingTeams(String sportname) throws RemoteException;
    public LinkedList<ISportsmanDTO> loadSportsman(String sportname, List<ISportsmanDTO> ignoreList) throws RemoteException;
    public ISportsmanTrainingTeamDTO AddTeamToPlayer(ITrainingTeamDTO TrainingTeam, ISportsmanDTO Sportsman, String position) throws RemoteException ;
}
