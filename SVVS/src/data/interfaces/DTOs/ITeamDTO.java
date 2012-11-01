/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ITeam;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ITeamDTO extends IDTO<ITeam> {

    void extract(ITeam model);

    String getName();

//    ISportDTO getSport();

    List<ITournamentDTO> getTournaments();

    void setName(String name);

//    void setSport(ISportDTO sport);

    void setTournaments(List<ITournamentDTO> tournaments);
    
}
