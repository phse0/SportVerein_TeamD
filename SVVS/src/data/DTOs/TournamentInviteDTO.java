/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ITournamentInvite;

/**
 *
 * @author uubu
 */
public class TournamentInviteDTO extends AbstractDTO<ITournamentInvite> implements ITournamentInviteDTO{

    private ITournamentDTO tournament;
    private ISportsmanDTO sportsman;
    private ITrainingTeamDTO team;
    private boolean accepted;
    
    public TournamentInviteDTO(ITournamentInvite model){
        if(model == null) return;
        extract(model);
    }
    
    @Override
    public void extract(ITournamentInvite model) {
        this.id = model.getTournamentInviteID();
        this.tournament = new TournamentDTO(model.getTournament());
        this.sportsman = new SportsmanDTO(model.getSportsman());
        this.team = new TrainingTeamDTO(model.getTeam());
        this.accepted = model.isAccepted();
        
    }

    @Override
    public ITournamentDTO getTournament() {
        return tournament;
    }

    @Override
    public void setTournament(ITournamentDTO tournament) {
        this.tournament = tournament;
    }

    @Override
    public ISportsmanDTO getSportsman() {
        return sportsman;
    }

    @Override
    public void setSportsman(ISportsmanDTO sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public boolean isAccepted() {
        return accepted;
    }

    @Override
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }   

    @Override
    public ITrainingTeamDTO getTeam() {
        return team;
    }

    @Override
    public void setTeam(ITrainingTeamDTO team) {
        this.team = team;
    }
    
    
}
