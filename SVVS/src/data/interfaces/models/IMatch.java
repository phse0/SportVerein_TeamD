/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import java.sql.Date;

/**
 *
 * @author uubu
 */
public interface IMatch extends IModel {

    int getMatchID();

    ITeam getTeam1();

    ITeam getTeam2();

    ITournament getTournament();

    void setMatchID(int matchID);

    void setTeam1(ITeam team1);

    void setTeam2(ITeam team2);

    void setTournament(ITournament tournament);

    Date getDate();

    Integer getGoalsTeam1();

    Integer getGoalsTeam2();

    String getLocation();

    void setDate(Date date);

    void setGoalsTeam1(Integer goalsTeam1);

    void setGoalsTeam2(Integer goalsTeam2);

    void setLocation(String location);

    String getResult();
    
}
