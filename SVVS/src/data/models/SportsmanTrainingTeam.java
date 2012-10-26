/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.ISportsman;
import data.interfaces.ISportsmanTrainingTeam;
import data.interfaces.ITrainingTeam;

/**
 *
 * @author Michael
 */
public class SportsmanTrainingTeam implements ISportsmanTrainingTeam {
    
    private ISportsman sportsman;
    private ITrainingTeam team;
    private String position;

    public SportsmanTrainingTeam() {
    }

    public SportsmanTrainingTeam(ISportsman sportsman, ITrainingTeam team, String position) {
        this.sportsman = sportsman;
        this.team = team;
        this.position = position;
    }

    @Override
    public ISportsman getSportsman() {
        return sportsman;
    }

    @Override
    public void setSportsman(ISportsman sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public ITrainingTeam getTeam() {
        return team;
    }

    @Override
    public void setTeam(ITrainingTeam team) {
        this.team = team;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }
    
    
    
}
