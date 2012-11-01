/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create.States;

import data.interfaces.models.IMatch;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Interface für alle Funktionen 
 * @author phil
 */
public interface ITournamentCreateState{
    public LinkedList<ISport> loadSport();
    public LinkedList<ITeam> loadTeams(ISport sport);
    public void CreateTournament(String name, String location, BigDecimal fee,
    String sportname, List<String> TeamNames);
}
