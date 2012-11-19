/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.edit.States;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ITournamentDTO;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phil
 */
public interface ITournamentEditState extends IController{
    public ITournamentDTO loadTournament(int ID) throws RemoteException;
    public void EditTournament(int ID, String name, String location, BigDecimal fee, boolean finished, List<String> TeamNames) throws RemoteException;
    public void AddMatch(int TournamentID, String location, Date date, String Team1Name, String Team2Name, Integer goalsTeam1, Integer goalsTeam2) throws RemoteException;
}
