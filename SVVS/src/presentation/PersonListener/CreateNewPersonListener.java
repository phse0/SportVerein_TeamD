/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.PersonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentation.forms.CreatePersonDialog;

/**
 *
 * @author Kno
 */
public class CreateNewPersonListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        new CreatePersonDialog(null, true).setVisible(true);
    }
    
}
