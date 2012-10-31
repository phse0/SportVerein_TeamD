/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ICoach;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITrainingTeam;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uubu
 */
public class TrainingTeamDTO extends AbstractTeamDTO<ITrainingTeam> implements ITrainingTeamDTO {

    protected IDepartmentDTO department;
    protected List<ISportsmanTrainingTeamDTO> sportsmen;
    protected List<ICoachDTO> coaches;

    @Override
    public void extract(ITrainingTeam model) {
        extractTeam(model);
        this.department = new DepartmentDTO(model.getDepartment());
        
        for(ISportsmanTrainingTeam stt: model.getSportsmen()){
            sportsmen.add(new SportsmanTrainingTeamDTO(stt));
        }
        
        for(ICoach coach: model.getCoaches()){
            coaches.add(new CoachDTO(coach));
        }
    }
    
    public TrainingTeamDTO(ITrainingTeam model){
        sportsmen = new LinkedList<>();
        coaches = new LinkedList<>();
        extract(model);
    }

    public IDepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(IDepartmentDTO department) {
        this.department = department;
    }

    public List<ISportsmanTrainingTeamDTO> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<ISportsmanTrainingTeamDTO> sportsmen) {
        this.sportsmen = sportsmen;
    }

    public List<ICoachDTO> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<ICoachDTO> coaches) {
        this.coaches = coaches;
    }

}
