/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import business.controller.RMI.IControllerFactory;
import business.controller.person.create.IPersonCreation;
import business.controller.person.edit.IPersonEdit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    IControllerFactory factory;

    public EditPersonListener(JTable table, IControllerFactory factory) {
        _table = table;
        this.factory = factory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie bearbeiten möchten.");
        } else {
            int index = _table.convertRowIndexToModel(_table.getSelectedRow());
            PersonTableModel personModel = (PersonTableModel) _table.getModel();

            try {
                IPersonCreation personEdit = factory.loadPersonCreateController();
                new CreatePersonDialog(null, true, personEdit, personModel.getPersonDTO(index)).setVisible(true);
            } catch (RemoteException ex) {
                Logger.getLogger(EditPersonListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ((PersonTableModel) _table.getModel()).fireTableDataChanged();
    }
}
