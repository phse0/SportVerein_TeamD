/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
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
    public LinkedList<ISportDTO> loadSport();
    public LinkedList<ITeamDTO> loadTeams(String sport);
    public void CreateTournament(String name, String location, BigDecimal fee,
    String sportname, List<String> TeamNames);
}
