/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITournamentInvite;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uubu
 */
public class SportsmanDTO extends AbstractRoleDTO<ISportsman> implements ISportsmanDTO {

    private List<ISportsmanTrainingTeamDTO> teams;
    private List<ITournamentInviteDTO> invites;
    
    public SportsmanDTO(ISportsman model){
        teams = new LinkedList<>();
        invites = new LinkedList<>();
        extract(model);
    }
    
    @Override
    public void extract(ISportsman model) {
        extractRole(model);
        
        for(ISportsmanTrainingTeam stt: model.getTeams()){
            teams.add(new SportsmanTrainingTeamDTO(stt));
        }
        
        for(ITournamentInvite ti: model.getInvites()){
            invites.add(new TournamentInviteDTO(ti));
        }
    }
    
}
