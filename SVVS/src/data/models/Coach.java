/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ICoach;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Coach extends Role implements ICoach{

    private List<TrainingTeam> teams;
    
    public Coach() {
        super();
    }

    @Override
    public List<TrainingTeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<TrainingTeam> teams) {
        this.teams = teams;
    }

}
