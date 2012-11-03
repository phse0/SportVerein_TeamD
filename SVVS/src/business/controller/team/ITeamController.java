/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ITeamDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public interface ITeamController extends Remote, IController  {
    public LinkedList<ITeamDTO> loadTeams()  throws RemoteException;
    public LinkedList<ITeamDTO> loadTeams(String sportname) throws RemoteException;
}
