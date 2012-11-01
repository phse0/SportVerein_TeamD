/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.edit.States;

import data.interfaces.DTOs.ITournamentDTO;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phil
 */
public interface ITournamentEditState {
    public ITournamentDTO loadTournament(int ID);
    public void EditTournament(int ID, String name, String location, BigDecimal fee, String sportname, List<String> TeamNames);
    public void AddMatch(int TournamentID, String location, Date date, String Team1Name, String Team2Name, Integer goalsTeam1, Integer goalsTeam2);
}
