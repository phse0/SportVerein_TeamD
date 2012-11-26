/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.JMS;

import business.controller.RMI.IController;
import business.messages.jms.interfaces.IMessage;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Evgeniya Spiegel
 */
public interface IMessageController extends Remote, IController {

    List<IMessage> LoadMessages(String username) throws RemoteException, Exception;

    boolean createInviteMessage(ITournamentInviteDTO tinvite) throws RemoteException;

    void createQueue(String username) throws RemoteException, Exception;

    boolean createSportsmanAssignedMessage(List<String> usernames, ISportsmanDTO sportsman, ITrainingTeamDTO team) throws RemoteException;

    boolean createSportsmanCreatedMessage(List<String> usernames, ISportsmanDTO sportsman) throws RemoteException;
    
}
