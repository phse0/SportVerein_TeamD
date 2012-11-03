/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.matchListeners;

import business.controller.tournament.edit.ITournamentEdit;
import data.interfaces.DTOs.ITournamentDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.CreateMatchDialog;
import presentation.tableModels.MatchTableModel;

/**
 *
 * @author Michael
 */
public class EditMatchListener implements ActionListener {

    JTable table;
    ITournamentEdit editController;
    ITournamentDTO tournament;

    public EditMatchListener(JTable table, ITournamentEdit editController, ITournamentDTO tournament) {
        this.table = table;
        this.editController = editController;
        this.tournament = tournament;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie bearbeiten möchten.");
        } else {
            int index = table.convertRowIndexToModel(table.getSelectedRow());
            MatchTableModel matchModel = (MatchTableModel) table.getModel();

            CreateMatchDialog dialog = new CreateMatchDialog(null, true, editController, tournament, matchModel.getMatchDTO(index));
            dialog.setVisible(true);

            if(dialog.getMatch() != null) {
                matchModel.updateMatchDTO(index, dialog.getMatch());
                matchModel.fireTableDataChanged();
            }
        }
    }
}
