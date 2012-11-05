/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import java.util.List;

/**
 *
 * @author uubu
 */
public interface ITeam extends IModel {

    String getName();

    ISport getSport();

    int getTeamID();

    void setName(String name);

    void setSport(ISport sport);

    void setTeamID(int teamID);

    List<ITournament> getTournaments();

    void setTournaments(List<ITournament> tournaments);

    ILeague getLeague();

    void setLeague(ILeague league);
    
}
