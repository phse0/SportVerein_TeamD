/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ITournament;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public interface ITournamentController extends Remote, IController {

    public LinkedList<ITeamDTO> loadTeams(String sportname) throws RemoteException;

    public LinkedList<ISportDTO> loadSport(List<IDepartmentDTO> department) throws RemoteException;

    public LinkedList<ITournamentDTO> loadTournaments() throws RemoteException;

    public ITournament loadTournament(int ID) throws RemoteException;
}
