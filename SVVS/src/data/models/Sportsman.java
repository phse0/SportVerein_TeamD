/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ISportsman;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Sportsman extends Role implements ISportsman{

    private List<SportsmanTrainingTeam> teams;
    
    public Sportsman() {
        super();
    }

    @Override
    public List<SportsmanTrainingTeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<SportsmanTrainingTeam> teams) {
        this.teams = teams;
    }    
}
