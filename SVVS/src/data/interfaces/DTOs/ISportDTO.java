/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ISport;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ISportDTO extends IDTO<ISport> {

    int getMaxPlayers();

    String getName();

//    List<ITeamDTO> getTeams();

    void setMaxPlayers(int maxPlayers);

    void setName(String name);
//
//    void setTeams(List<ITeamDTO> teams);
    
}
