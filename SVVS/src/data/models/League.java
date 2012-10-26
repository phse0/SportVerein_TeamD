/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ILeague;
import data.interfaces.models.ITournamentTeam;
import java.util.List;

/**
 *
 * @author Michael
 */
public class League implements ILeague {
    
    private int leagueID;
    private String name;
    private List<ITournamentTeam> tournamentTeams;

    public League() {
    }

    public League(String name) {
        this.name = name;
    }

    @Override
    public int getLeagueID() {
        return leagueID;
    }

    @Override
    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
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
    public List<ITournamentTeam> getTournamentTeams() {
        return tournamentTeams;
    }

    @Override
    public void setTournamentTeams(List<ITournamentTeam> tournamentTeams) {
        this.tournamentTeams = tournamentTeams;
    }
    
    @Override
    public void addTournamentTeam(ITournamentTeam team) {
        this.tournamentTeams.add(team);
    }
    
    @Override
    public void removeTournamentTeam(ITournamentTeam team) {
        this.tournamentTeams.remove(team);
    }
    
}
