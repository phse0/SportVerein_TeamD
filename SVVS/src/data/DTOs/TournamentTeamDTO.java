/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITournamentTeamDTO;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITournamentTeam;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uubu
 */
public class TournamentTeamDTO extends AbstractTeamDTO<ITournamentTeam> implements ITournamentTeamDTO {

   
    protected IDepartmentDTO department;
    protected List<ISportsmanTrainingTeamDTO> sportsmen;
    //protected List<ICoachDTO> coaches;
    
    public TournamentTeamDTO(ITournamentTeam model){
        sportsmen = new LinkedList<>();
        extract(model);
    }

    @Override
    public void extract(ITournamentTeam model) {
        extractTeam(model);
       
        this.department = new DepartmentDTO(model.getDepartment());
        
        for(ISportsmanTrainingTeam stt: model.getSportsmen()){
            sportsmen.add(new SportsmanTrainingTeamDTO(stt));
        }
        
//        for(ICoach coach: model.getCoaches()){
//            coaches.add(new CoachDTO(coach));
//        }
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
    public List<ISportsmanTrainingTeamDTO> getSportsmen() {
        return sportsmen;
    }

    @Override
    public void setSportsmen(List<ISportsmanTrainingTeamDTO> sportsmen) {
        this.sportsmen = sportsmen;
    }
    
     
    @Override
    public void addSportsmen(ISportsmanTrainingTeamDTO sportsmen) {
        this.sportsmen.add(sportsmen);
    }
    
    @Override
    public void removeSportsmen(ISportsmanTrainingTeamDTO sportsmen) {
        this.sportsmen.remove(sportsmen);
    }

//    @Override
//    public List<ICoachDTO> getCoaches() {
//        return coaches;
//    }
//
//    @Override
//    public void setCoaches(List<ICoachDTO> coaches) {
//        this.coaches = coaches;
//    }

    @Override
    public String getTeamName() {
        return name;
    }

    @Override
    public void setTeamName(String name) {
        this.name = name;
    }

    @Override
    public ISportDTO getSport() {
        return sport;
    }

    @Override
    public void setSport(ISportDTO sport) {
        this.sport = sport;
    }
  
}
