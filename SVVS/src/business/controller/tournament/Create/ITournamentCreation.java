/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.util.LinkedList;
import java.util.List;


/**
 * Context für den Use Case neues Tournament, GUI sollte interface von dem
 * kriegen
 *
 * First LoadSport
 * Second LoadTeams
 * Third CreateTournament
 * @author phil
 */
public interface ITournamentCreation extends Remote  {
    public LinkedList<ISport> loadSport();
    public LinkedList<ITeam> loadTeams(ISport sport);
    public void CreateTournament(String name, String location, BigDecimal fee,
    String sportname, List<String> TeamNames);
}
