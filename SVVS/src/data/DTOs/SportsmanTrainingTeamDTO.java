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
    protected ITrainingTeamDTO team;
    protected String position;
    
    public SportsmanTrainingTeamDTO(ISportsmanTrainingTeam model){
        extract(model);
    }
    
    @Override
    public void extract(ISportsmanTrainingTeam model) {
        this.id = model.getSportsmanTrainingTeamID();
        this.sportsman = new SportsmanDTO(model.getSportsman());
        this.team = new TrainingTeamDTO(model.getTeam());
    }
    
}
