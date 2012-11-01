/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import business.controller.person.create.IPersonCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michael
 */
public class SavePersonListener implements ActionListener {
    
    IPersonCreation creation;
    
    public SavePersonListener(IPersonCreation creation) {
        this.creation = creation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
