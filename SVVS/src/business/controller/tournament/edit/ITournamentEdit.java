/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.edit;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public interface ITournamentEdit extends Remote, IController {

    public LinkedList<ITournamentDTO> loadTournaments() throws RemoteException;
    public LinkedList<ITeamDTO> loadTeams(String sport) throws RemoteException;
    //only this two with state behaviour
    public ITournamentDTO loadTournament(int ID) throws RemoteException;
    public void EditTournament(int ID, String name, String location, BigDecimal fee, List<String> TeamNames) throws RemoteException;
    public void AddMatch(int TournamentID, String location, Date date, String Team1Name, String Team2Name, Integer goalsTeam1, Integer goalsTeam2) throws RemoteException;
    public void EditMatch(int MatchID, String location, Date date, String Team1Name, String Team2Name, Integer goalsTeam1, Integer goalsTeam2) throws RemoteException;
}
