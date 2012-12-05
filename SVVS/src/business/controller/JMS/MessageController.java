/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.JMS;

import business.controller.RMI.AController;
import business.messages.jms.SportsmanAssignedMessage;
import business.messages.jms.SportsmanCreatedMessage;
import business.messages.jms.TournamentInviteMessage;
import business.messages.jms.interfaces.IMessage;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author Evgeniya Spiegel
 */
public class MessageController extends AController implements IMessageController {

    private InitialContext initialContext;
    private ConnectionFactory connectionFactory;
    private Destination destination;
    private Session session;
    private Connection connection;
    private static MessageController instance;
    private String authorID;

    private MessageController(String authorid) throws RemoteException {
        super();
        this.authorID = authorid;
        //Diese Properties sind sehr wichtig, weil ohne dessen geht es nicht ??????
        Properties props = new Properties();

        props.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");

        props.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");

        props.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        try {
            initialContext = new InitialContext(props);
            connectionFactory = (ConnectionFactory) initialContext.lookup("jms/CF");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.close();
        } catch (Exception e) {
        }



    }

    public static MessageController getInstance(String authorid) throws RemoteException, Exception {
        if (instance == null) {
            instance = new MessageController(authorid);
        }
        return instance;
    }

    @Override
    public void createQueue(String username) throws RemoteException, Exception {

        Queue queue = session.createQueue("jms/" + username);
        initialContext.bind("jms/" + username, queue);
    }
    //Consumer is a sportsman with username username, and he(she)should get the loaded messages  

    @Override
    public List<IMessage> LoadMessages(String username) throws RemoteException, Exception {

        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);



        Destination dest = (Destination) initialContext.lookup("jms/" + username);
        LinkedList<IMessage> messages = new LinkedList<>();

        // Create a MessageConsumer
        MessageConsumer consumer = session.createConsumer(dest);
        // Start the connection, causing message delivery to begin
        // Receive the messages sent to the destination

//Mit receiveNoWait hat nicht funktioniert und mit receive(1000l) funktioniert es
        ObjectMessage msg = (ObjectMessage) consumer.receive(1000l);
        while (msg != null) {
            messages.add((IMessage) msg.getObject());
            msg = (ObjectMessage) consumer.receive(1000l);
        }

        connection.close();
        return messages;
    }
    //tinvite has a list of persons to invite

    @Override
    public boolean createInviteMessage(ITournamentInviteDTO tinvite) throws RemoteException {
        ISportsmanDTO sportsman = tinvite.getSportsman();
        ITournamentDTO tournament = tinvite.getTournament();
        ITrainingTeamDTO team = tinvite.getTeam();
        IMessage inviteMessage = new TournamentInviteMessage(authorID, sportsman, tournament, team);
        saveMessage(inviteMessage, sportsman.getPerson().getUsername());
        return true;
    }

    @Override
    public boolean createSportsmanCreatedMessage(List<String> usernames, ISportsmanDTO sportsman) throws RemoteException {

        SportsmanCreatedMessage sportsmanCreateMessage = new SportsmanCreatedMessage(authorID, sportsman);
        for (String un : usernames) {
            saveMessage(sportsmanCreateMessage, un);
        }
        return true;
    }

    @Override
    public boolean createSportsmanAssignedMessage(List<String> usernames, ISportsmanDTO sportsman, ITrainingTeamDTO team) throws RemoteException {
        SportsmanAssignedMessage sportsmanAssignedMessage = new SportsmanAssignedMessage(authorID, team, sportsman);
        for (String un : usernames) {
            saveMessage(sportsmanAssignedMessage, un);
        }

        return true;
    }

    private void saveMessage(IMessage o, String username) throws RemoteException {
        try {
// get the Destination used to send the message by JNDI name
            // connection.start();

            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


            destination = (Destination) initialContext.lookup("jms/" + username);
// Create a connection
            MessageProducer producer = session.createProducer(destination);

            ObjectMessage msg = session.createObjectMessage(o);
// send the message to the destination
            producer.send(msg);
            connection.close();
// Close the connection
        } catch (Exception e) {
        }
    }
}
