/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ILeague;
import data.interfaces.models.ITeam;
import java.util.List;

/**
 *
 * @author Michael
 */
public class League implements ILeague {
    
    private int leagueID;
    private String name;
    private List<ITeam> teams;

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
    public List<ITeam> getTeams() {
        return teams;
    }


    @Override
    public void setTeams(List<ITeam> teams) {
        this.teams = teams;
    }
    

    @Override
    public void addTeam(ITeam team) {
        this.teams.add(team);
    }
    

    @Override
    public void removeTeam(ITeam team) {
        this.teams.remove(team);
    }
    
}
