/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITournamentTeamDTO;
import data.interfaces.models.ICoach;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITournamentTeam;
import java.util.List;

/**
 *
 * @author uubu
 */
public class TournamentTeamDTO extends AbstractTeamDTO<ITournamentTeam> implements ITournamentTeamDTO {

    protected ILeagueDTO league;
     protected IDepartmentDTO department;
    protected List<ISportsmanTrainingTeamDTO> sportsmen;
    protected List<ICoachDTO> coaches;
    
    public TournamentTeamDTO(ITournamentTeam model){
        extract(model);
    }

    public ILeagueDTO getLeague() {
        return league;
    }

    public void setLeague(ILeagueDTO league) {
        this.league = league;
    }

    @Override
    public void extract(ITournamentTeam model) {
        extractTeam(model);
        this.league = new LeagueDTO(model.getLeague());
        this.department = new DepartmentDTO(model.getDepartment());
        
        for(ISportsmanTrainingTeam stt: model.getSportsmen()){
            sportsmen.add(new SportsmanTrainingTeamDTO(stt));
        }
        
        for(ICoach coach: model.getCoaches()){
            coaches.add(new CoachDTO(coach));
        }
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
