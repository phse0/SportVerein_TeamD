/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ITournament;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public interface ITournamentController extends Remote, IController  {
    public LinkedList<ISportDTO >loadSport() throws RemoteException;
    public LinkedList<ITournamentDTO> loadTournaments() throws RemoteException;
    public ITournament loadTournament(int ID) throws RemoteException;
    public LinkedList<ITeamDTO> loadTeams(String sportname) throws RemoteException;
}
