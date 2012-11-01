/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.edit;

import business.controller.RMI.IController;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import java.rmi.Remote;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public interface ITournamentEdit extends Remote, IController {

    public LinkedList<ITournamentDTO> loadTournaments();
    public LinkedList<ITeamDTO> loadTeams(String sport);
    //only this two with state behaviour
    public ITournamentDTO loadTournament(int ID);
    public void AddMatch(int TournamentID, String location, Date date, String Team1Name, String Team2Name, Integer goalsTeam1, Integer goalsTeam2);
}
