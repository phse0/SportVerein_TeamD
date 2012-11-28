/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.messages.jms;

import business.messages.jms.interfaces.ISportsmanAssignedMessage;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import org.joda.time.DateTime;

/**
 *
 * @author uubu
 */
public class SportsmanAssignedMessage extends GeneralMessage implements ISportsmanAssignedMessage {

    private ISportsmanDTO sportsman;
    private ITrainingTeamDTO team;

    public SportsmanAssignedMessage(String authorID, ITrainingTeamDTO team, ISportsmanDTO sportsman) {
        super(authorID);
        if (team == null || sportsman == null) {
            return;
        }
        this.text = getSportsman().getPerson() + " wurde dem Team " + getTeam() + " zugewiesen!";
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

    /* @Override
     public String getText() {
     return this.text;
     }
     */


}
