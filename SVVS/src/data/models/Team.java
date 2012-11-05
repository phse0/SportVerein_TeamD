/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ILeague;
import data.interfaces.models.IMatch;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
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
     protected ILeague league;


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
    public ILeague getLeague() {
        return league;
    }

    @Override
    public void setLeague(ILeague league) {
        this.league = league;
    }
}
