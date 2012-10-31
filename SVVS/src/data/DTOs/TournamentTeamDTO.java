/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.DTOs.ITournamentTeamDTO;
import data.interfaces.models.ITournamentTeam;

/**
 *
 * @author uubu
 */
public class TournamentTeamDTO extends AbstractTeamDTO<ITournamentTeam> implements ITournamentTeamDTO {

    protected ILeagueDTO league;

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
    }

   
    
}
