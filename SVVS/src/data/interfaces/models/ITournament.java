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
public interface ITournament {

    void addMatch(IMatch match);

    void addTeam(ITeam team);

    List<IMatch> getMatches();

    String getName();

    List<ITeam> getTeams();

    int getTournamentID();

    void removeMatch(IMatch match);

    void removeTeam(ITeam team);

    void setMatches(List<IMatch> matches);

    void setName(String name);

    void setTeams(List<ITeam> teams);

    void setTournamentID(int tournamentID);
    
}
