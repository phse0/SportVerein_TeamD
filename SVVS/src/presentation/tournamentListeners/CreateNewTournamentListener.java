/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentListeners;

import business.controller.RMI.IControllerFactory;
import business.controller.tournament.Create.ITournamentCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import presentation.forms.CreateTournamentDialog;
import presentation.tableModels.TournamentTableModel;

/**
 *
 * @author Michael
 */
public class CreateNewTournamentListener implements ActionListener {

    JTable table;
    IControllerFactory controllerfactory;
    
    public CreateNewTournamentListener(JTable table, IControllerFactory controller) {
        this.table = table;
        this.controllerfactory = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ITournamentCreation create = null;
        try {
            create = controllerfactory.loadTournamentCreateController();
            CreateTournamentDialog dialog = new CreateTournamentDialog(null, true, create);
            dialog.setVisible(true);
            
            if(dialog.getSavedTournament() != null) {
                TournamentTableModel tableModel = (TournamentTableModel) table.getModel();
                tableModel.addTournament(dialog.getSavedTournament());
                tableModel.fireTableDataChanged();
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(CreateNewTournamentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       ((TournamentTableModel) table.getModel()).fireTableDataChanged();

    }
}
