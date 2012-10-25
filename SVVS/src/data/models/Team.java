/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.IMatch;
import data.interfaces.ISport;
import data.interfaces.ITeam;
import data.interfaces.ITournament;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Team implements ITeam {
    
    protected int teamID;
    protected String name;
    protected ISport sport;
    protected List<ITournament> tournaments;
    protected List<IMatch> matches;

    public Team() {
    }

    public Team(String name, ISport sport) {
        this.name = name;
        this.sport = sport;
    }

    @Override
    public int getTeamID() {
        return teamID;
    }

    @Override
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ISport getSport() {
        return sport;
    }

    @Override
    public void setSport(ISport sport) {
        this.sport = sport;
    }

    @Override
    public List<ITournament> getTournaments() {
        return tournaments;
    }

    @Override
    public void setTournaments(List<ITournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public List<IMatch> getMatches() {
        return matches;
    }

    @Override
    public void setMatches(List<IMatch> matches) {
        this.matches = matches;
    }
    
}