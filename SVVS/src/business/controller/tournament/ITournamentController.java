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
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public interface ITournamentController extends Remote, IController  {
    public LinkedList<ISportDTO >loadSport();
    public LinkedList<ITournamentDTO> loadTournaments();
    public ITournament loadTournament(int ID) ;
    public LinkedList<ITeamDTO> loadTeams(String sportname);
}
