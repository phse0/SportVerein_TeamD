/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ILeague;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ILeagueDTO extends IDTO<ILeague>{

    String getName();

    List<ITournamentTeamDTO> getTournamentTeams();

    void setName(String name);

    void setTournamentTeams(List<ITournamentTeamDTO> tournamentTeams);
    
}
