/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsmanTrainingTeam;

/**
 *
 * @author uubu
 */
public class SportsmanTrainingTeamDTO extends AbstractDTO<ISportsmanTrainingTeam> implements ISportsmanTrainingTeamDTO{

    protected ISportsmanDTO sportsman;
//    protected ITrainingTeamDTO team;
    protected String position;
    
    public SportsmanTrainingTeamDTO(ISportsmanTrainingTeam model){
        extract(model);
    }
    
    @Override
    public void extract(ISportsmanTrainingTeam model) {
        this.id = model.getSportsmanTrainingTeamID();
        this.sportsman = new SportsmanDTO(model.getSportsman());
        this.position = model.getPosition();
        //this.team = new TrainingTeamDTO(model.getTeam());
    }

    public ISportsmanDTO getSportsman() {
        return sportsman;
    }

    public void setSportsman(ISportsmanDTO sportsman) {
        this.sportsman = sportsman;
    }

//    public ITrainingTeamDTO getTeam() {
//        return team;
//    }
//
//    public void setTeam(ITrainingTeamDTO team) {
//        this.team = team;
//    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
