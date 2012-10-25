/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces;

import java.util.List;

/**
 *
 * @author uubu
 */
public interface ITeam {

    String getName();

    ISport getSport();

    int getTeamID();

    void setName(String name);

    void setSport(ISport sport);

    void setTeamID(int teamID);

    List<IMatch> getMatches();

    List<ITournament> getTournaments();

    void setMatches(List<IMatch> matches);

    void setTournaments(List<ITournament> tournaments);
    
}
