/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentation.forms.CreateTournamentDialog;

/**
 *
 * @author Michael
 */
public class CreateNewTournamentListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        new CreateTournamentDialog(null, true).setVisible(true);
    }
    
}
