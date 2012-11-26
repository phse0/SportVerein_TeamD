/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.JMS;

import business.messages.jms.interfaces.IMessage;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import java.util.List;

/**
 *
 * @author Media Markt
 */
public interface IMessageController {

    List<IMessage> LoadMessages(String username) throws Exception;

    boolean createInviteMessage(ITournamentInviteDTO tinvite);

    void createQueue(String username) throws Exception;

    boolean createSportsmanAssignedMessage(List<String> usernames, ISportsmanDTO sportsman, ITrainingTeamDTO team);

    boolean createSportsmanCreatedMessage(List<String> usernames, ISportsmanDTO sportsman);
    
}
