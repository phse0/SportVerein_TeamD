/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create.States;

import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Interface für alle Funktionen 
 * @author phil
 */
public interface ITournamentCreateState{
    public LinkedList<ISportDTO> loadSport();
    public LinkedList<ITeamDTO> loadTeams(String sport);
    public void CreateTournament(String name, String location, BigDecimal fee,
    String sportname, List<String> TeamNames);
}
