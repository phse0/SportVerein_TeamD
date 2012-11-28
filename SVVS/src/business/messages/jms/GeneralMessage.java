/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.messages.jms;

import business.messages.jms.interfaces.IMessage;
import org.joda.time.DateTime;

/**
 *
 * @author Media Markt
 */
public class GeneralMessage implements IMessage {

    protected String text;
    protected DateTime sendDate;
    protected String authorID;

    public GeneralMessage(String authorID) {
        sendDate = new DateTime();
        this.authorID = authorID;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public DateTime getDate() {
        return this.sendDate;
    }

    @Override
    public String getAuthorId() {
        return this.authorID;
    }
}
