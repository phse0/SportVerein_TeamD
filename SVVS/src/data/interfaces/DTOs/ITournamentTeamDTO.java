/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ITournamentTeam;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ITournamentTeamDTO extends IDTO<ITournamentTeam>{

    void extract(ITournamentTeam model);

    List<ICoachDTO> getCoaches();
    
    String getTeamName();

//    ISportDTO getSport();
    
    IDepartmentDTO getDepartment();

    ILeagueDTO getLeague();

    List<ISportsmanTrainingTeamDTO> getSportsmen();

    void setCoaches(List<ICoachDTO> coaches);
    
    void setTeamName(String name);
    
//    void setSport(ISportDTO sport);

    void setDepartment(IDepartmentDTO department);

    void setLeague(ILeagueDTO league);

    void setSportsmen(List<ISportsmanTrainingTeamDTO> sportsmen);

    ISportDTO getSport();

    void setSport(ISportDTO sport);

    void addSportsmen(ISportsmanTrainingTeamDTO sportsmen);

    void removeSportsmen(ISportsmanTrainingTeamDTO sportsmen);
    
}
