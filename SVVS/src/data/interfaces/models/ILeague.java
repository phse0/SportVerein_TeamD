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
public interface ILeague extends IModel {

    int getLeagueID();

    String getName();

    void setLeagueID(int leagueID);

    void setName(String name);

    void addTeam(ITeam team);

    List<ITeam> getTeams();

    void removeTeam(ITeam team);

    void setTeams(List<ITeam> teams);
    
}
