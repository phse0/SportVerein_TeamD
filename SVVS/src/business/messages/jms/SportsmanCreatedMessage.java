/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.messages.jms;

import business.messages.jms.interfaces.ISportsmanCreatedMessage;
import data.interfaces.DTOs.ISportsmanDTO;

/**
 *
 * @author uubu
 */
public class SportsmanCreatedMessage implements ISportsmanCreatedMessage {

    private ISportsmanDTO sportsman;
    
    public SportsmanCreatedMessage(ISportsmanDTO sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public ISportsmanDTO getSportsman() {
        return this.sportsman;
    }

    @Override
    public String getText() {
        return getSportsman().getPerson() + " wurde der Abteilung " + getSportsman().getDepartment() + " und der Sportart " + getSportsman().getSport() + " zugewiesen!";
    }
    
}
