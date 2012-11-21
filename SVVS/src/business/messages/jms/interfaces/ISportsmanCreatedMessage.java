/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.messages.jms.interfaces;

import data.interfaces.DTOs.ISportsmanDTO;

/**
 *
 * @author uubu
 */
public interface ISportsmanCreatedMessage extends IMessage{
    
    ISportsmanDTO getSportsman();
    
}
