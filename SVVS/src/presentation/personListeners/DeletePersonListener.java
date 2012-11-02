/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import business.controller.RMI.IControllerFactory;
import data.interfaces.DTOs.IPersonDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.tableModels.PersonTableModel;

/**
 * DeletePersonListener benötigt die JTable damit er den aktuellen Datensatz
 * löschen kann!
 *
 * @author Kno
 */
public class DeletePersonListener implements ActionListener {

    JTable _table;
    IControllerFactory controller;

    public DeletePersonListener(JTable table, IControllerFactory controller) {
        _table = table;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (_table.getSelectedRow() != -1) {
            if (JOptionPane.showConfirmDialog(null,
                    "Wollen sie die Person wirklich löschen?", "",
                    JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                //LÖSCHEN
                
                int index = _table.convertRowIndexToModel(_table.getSelectedRow());
                PersonTableModel personModel = (PersonTableModel) _table.getModel();
                IPersonDTO person = personModel.getPersonDTO(index);
                
                try {
                controller.loadPersonDeleteController().removePerson(person);
                } catch (RemoteException ex) {
                    System.out.println("Löschen fehlgeschlagen");
                }
            } else {
                //will doch nicht löschen!
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie löschen möchten.");
        }
    }
}
