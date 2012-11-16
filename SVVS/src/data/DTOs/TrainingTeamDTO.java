/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.DTOs.ISportDTO;
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
        if(model == null) return;
        
        coaches = new LinkedList<>();
        sportsmen = new LinkedList<>();
        
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
//        sportsmen = new LinkedList<>();
//        coaches = new LinkedList<>();
        extract(model);
    }

    @Override
    public IDepartmentDTO getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(IDepartmentDTO department) {
        this.department = department;
    }

    @Override
    public String getName() {
        return super.getName();
    }
    
    

    @Override
    public List<ISportsmanTrainingTeamDTO> getSportsmen() {
        return sportsmen;
    }

    @Override
    public void setSportsmen(List<ISportsmanTrainingTeamDTO> sportsmen) {
        this.sportsmen = sportsmen;
    }

    @Override
    public List<ICoachDTO> getCoaches() {
        return coaches;
    }

    @Override
    public void setCoaches(List<ICoachDTO> coaches) {
        this.coaches = coaches;
    }

        @Override
    public ISportDTO getSport() {
        return sport;
    }

    @Override
    public void setSport(ISportDTO sport) {
        this.sport = sport;
    }
    
    @Override
        public ILeagueDTO getLeague() {
        return league;
    }

    @Override
    public void setLeague(ILeagueDTO league) {
        this.league = league;
    }
}
