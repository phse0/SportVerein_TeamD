/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ITournament;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ITournamentDTO extends IDTO<ITournament> {

    String getDate();

    double getFee();

    String getLocation();

    String getName();

    void setDate(String date);

    void setFee(double fee);

    void setLocation(String location);

    void setName(String name);

    List<ITournamentInviteDTO> getInvites();

    List<IMatchDTO> getMatches();

    List<ITeamDTO> getTeams();

    void setInvites(List<ITournamentInviteDTO> invites);

    void setMatches(List<IMatchDTO> matches);

    void setTeams(List<ITeamDTO> teams);

    ISportDTO getSport();

    void setSport(ISportDTO sport);

    
}
