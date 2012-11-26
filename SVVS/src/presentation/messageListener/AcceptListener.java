/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.messageListener;

import business.controller.touramentTeam.ITournamentTeamController;
import business.messages.jms.interfaces.ITournamentInviteMessage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import presentation.tableModels.MessageTableModel;

/**
 *
 * @author Michael
 */
public class AcceptListener implements ActionListener {

    ITournamentTeamController controller;
    JTable table;

    public AcceptListener(ITournamentTeamController controller, JTable table) {
        this.controller = controller;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = table.convertRowIndexToModel(table.getSelectedRow());
        MessageTableModel model = (MessageTableModel) table.getModel();
        
        if(model.getMessage(index) instanceof ITournamentInviteMessage) {
            ITournamentInviteMessage message = (ITournamentInviteMessage) model.getMessage(index);
            try {
                controller.acceptInvite(message, true);
                
                model.removeRow(index);
            } catch (RemoteException ex) {
                Logger.getLogger(AcceptListener.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
}
