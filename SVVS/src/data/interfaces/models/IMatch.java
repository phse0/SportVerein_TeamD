/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface IMatch {

    int getMatchID();

    ITeam getTeam1();

    ITeam getTeam2();

    ITournament getTournament();

    void setMatchID(int matchID);

    void setTeam1(ITeam team1);

    void setTeam2(ITeam team2);

    void setTournament(ITournament tournament);
    
}
