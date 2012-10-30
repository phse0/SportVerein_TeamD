/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import java.sql.Date;

/**
 *
 * @author Michael
 */
public class Match implements IMatch {
    
    private int matchID;
    private ITournament tournament;
    private String location;
    private Date date;
    private ITeam team1;
    private ITeam team2;
    private Integer goalsTeam1;
    private Integer goalsTeam2;

    public Match() {
    }

    public Match(ITournament tournament, ITeam team1, ITeam team2) {
        this.tournament = tournament;
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public int getMatchID() {
        return matchID;
    }

    @Override
    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    @Override
    public ITournament getTournament() {
        return tournament;
    }

    @Override
    public void setTournament(ITournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public ITeam getTeam1() {
        return team1;
    }

    @Override
    public void setTeam1(ITeam team1) {
        this.team1 = team1;
    }

    @Override
    public ITeam getTeam2() {
        return team2;
    }

    @Override
    public void setTeam2(ITeam team2) {
        this.team2 = team2;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Integer getGoalsTeam1() {
        return goalsTeam1;
    }

    @Override
    public void setGoalsTeam1(Integer goalsTeam1) {
        this.goalsTeam1 = goalsTeam1;
    }

    @Override
    public Integer getGoalsTeam2() {
        return goalsTeam2;
    }

    @Override
    public void setGoalsTeam2(Integer goalsTeam2) {
        this.goalsTeam2 = goalsTeam2;
    }
    
    public String getResult() {
        if(goalsTeam1 != null && goalsTeam2 != null) {
            return goalsTeam1 + " : " + goalsTeam2;
        } else {
            return "Noch keine Ergebnisse";
        }
    }
    
}
