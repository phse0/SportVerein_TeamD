/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.EditTournamentDialog;
import presentation.tableModels.TournamentTableModel;

/**
 *
 * @author Michael
 */
public class EditTournamentListener implements ActionListener {

    JTable _table;

    public EditTournamentListener(JTable table) {
        _table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst einen Wettbewerb aus, die sie bearbeiten möchten.");
        } else {
            int index = _table.convertRowIndexToModel(_table.getSelectedRow());
            TournamentTableModel tournamentModel = (TournamentTableModel) _table.getModel();
            new EditTournamentDialog(null, true, tournamentModel.getTournamentDTO(index)).setVisible(true);
        }
    }
}
