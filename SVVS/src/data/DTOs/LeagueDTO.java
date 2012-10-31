/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.DTOs.ITournamentTeamDTO;
import data.interfaces.models.ILeague;
import data.interfaces.models.ITournamentTeam;
import java.util.List;

/**
 *
 * @author uubu
 */
public class LeagueDTO extends AbstractDTO<ILeague> implements ILeagueDTO{

    private String name;
    private List<ITournamentTeamDTO> tournamentTeams;
    
    public LeagueDTO(ILeague model){
        extract(model);
    }
   
    @Override
    public void extract(ILeague model) {
        this.id = model.getLeagueID();
        
        for(ITournamentTeam tt: model.getTournamentTeams()){
            this.tournamentTeams.add(new TournamentTeamDTO(tt));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ITournamentTeamDTO> getTournamentTeams() {
        return tournamentTeams;
    }

    public void setTournamentTeams(List<ITournamentTeamDTO> tournamentTeams) {
        this.tournamentTeams = tournamentTeams;
    }
    
    
}
