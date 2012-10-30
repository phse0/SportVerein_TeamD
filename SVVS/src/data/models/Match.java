/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;

/**
 *
 * @author Michael
 */
public class Match implements IMatch {
    
    private int matchID;
    private ITournament tournament;
    private ITeam team1;
    private ITeam team2;
    private String result;

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
    public String getResult() {
        return result;
    }

    @Override
    public void setResult(String result) {
        this.result = result;
    }
}
