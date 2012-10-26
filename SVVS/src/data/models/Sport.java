/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Sport implements ISport {
    
    private int sportID;
    private String name;
    private int maxPlayers;
    private List<ITeam> teams;

    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
    }

    public Sport(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    @Override
    public int getSportID() {
        return sportID;
    }

    @Override
    public void setSportID(int sportID) {
        this.sportID = sportID;
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
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
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
