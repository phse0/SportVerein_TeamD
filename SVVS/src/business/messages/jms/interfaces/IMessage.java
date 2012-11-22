/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.messages.jms.interfaces;

import java.io.Serializable;

/**
 *
 * @author uubu
 */
public interface IMessage extends Serializable{
    
    String getText();
}
