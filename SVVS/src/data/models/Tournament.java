/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.IMatch;
import data.interfaces.ITeam;
import data.interfaces.ITournament;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Tournament implements ITournament {
    
    private int tournamentID;
    private String name;
    private List<ITeam> teams;
    private List<IMatch> matches;

    public Tournament() {
    }

    public Tournament(String name) {
        this.name = name;
    }

    @Override
    public int getTournamentID() {
        return tournamentID;
    }

    @Override
    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
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
    public List<ITeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<ITeam> teams) {
        this.teams = teams;
    }

    @Override
    public List<IMatch> getMatches() {
        return matches;
    }

    @Override
    public void setMatches(List<IMatch> matches) {
        this.matches = matches;
    }
    
    @Override
    public void addTeam(ITeam team) {
        this.teams.add(team);
    }
    
    @Override
    public void removeTeam(ITeam team) {
        this.teams.remove(team);
    }
    
    @Override
    public void addMatch(IMatch match) {
        this.matches.add(match);
    }
    
    @Override
    public void removeMatch(IMatch match) {
        this.matches.add(match);
    }
    
}
