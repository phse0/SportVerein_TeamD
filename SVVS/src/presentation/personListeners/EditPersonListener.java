/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.CreatePersonDialog;
import presentation.tableModels.PersonTableModel;

/**
 *
 * @author Kno
 */
public class EditPersonListener implements ActionListener {

    JTable _table;

    public EditPersonListener(JTable table) {
        _table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie bearbeiten möchten.");
        } else {
            int index = _table.convertRowIndexToModel(_table.getSelectedRow());
            PersonTableModel personModel = (PersonTableModel) _table.getModel();
            new CreatePersonDialog(null, true, personModel.getPersonDTO(index)).setVisible(true);
        }
    }
}
