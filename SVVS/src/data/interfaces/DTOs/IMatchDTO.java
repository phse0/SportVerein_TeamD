/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IMatch;

/**
 *
 * @author uubu
 */
public interface IMatchDTO extends IDTO<IMatch> {

    String getDate();

    Integer getGoalsTeam1();

    Integer getGoalsTeam2();

    String getLocation();

    ITeamDTO getTeam1();

    ITeamDTO getTeam2();

    ITournamentDTO getTournament();

    void setDate(String date);

    void setGoalsTeam1(Integer goalsTeam1);

    void setGoalsTeam2(Integer goalsTeam2);

    void setLocation(String location);

    void setTeam1(ITeamDTO team1);

    void setTeam2(ITeamDTO team2);

    void setTournament(ITournamentDTO tournament);
    
}
