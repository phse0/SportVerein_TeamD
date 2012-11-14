/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ICoach;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITrainingTeam;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uubu
 */
public class CoachDTO extends AbstractRoleDTO<ICoach> implements ICoachDTO {

    //private List<ITrainingTeamDTO> teams;
    
    public CoachDTO(ICoach model){
        if(model == null) return;
        //teams = new LinkedList<>();
        extract(model);
    }
    
    @Override
    public void extract(ICoach model) {
        extractRole(model);
        
        //for(ITeam team : model.getTeams()){
          //  teams.add(new TrainingTeamDTO((ITrainingTeam)team));
        //}
    }

//    @Override
//    public List<ITrainingTeamDTO> getTeams() {
//        return teams;
//    }
//
//    @Override
//    public void setTeams(List<ITrainingTeamDTO> teams) {
//        this.teams = teams;
//    }
    
    
    
}
