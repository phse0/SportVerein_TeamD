/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.messages.jms;

import business.messages.jms.interfaces.ISportsmanAssignedMessage;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;

/**
 *
 * @author uubu
 */
public class SportsmanAssignedMessage implements ISportsmanAssignedMessage{

    private ISportsmanDTO sportsman;
    private ITrainingTeamDTO team;
    
    
    public SportsmanAssignedMessage(ITrainingTeamDTO team, ISportsmanDTO sportsman) {
        
        if(team == null || sportsman == null){
            return;
        }
        
        this.sportsman = sportsman;
        this.team = team;
    }

    
    
    @Override
    public ISportsmanDTO getSportsman() {
        return this.sportsman;
    }

    @Override
    public ITrainingTeamDTO getTeam() {
        return this.team;
    }

    @Override
    public String getText() {
        return getSportsman().getPerson() + " wurde dem Team " + getTeam() + " zugewiesen!";
    }
    
}
