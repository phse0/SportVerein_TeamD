/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ICoach;
import data.interfaces.models.ITrainingTeam;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Coach extends Role implements ICoach{

    private List<ITrainingTeam> teams;
    
    public Coach() {
        super();
    }

    @Override
    public List<ITrainingTeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<ITrainingTeam> teams) {
        this.teams = teams;
    }

}
