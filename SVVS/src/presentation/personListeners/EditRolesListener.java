/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import business.controller.RMI.IControllerFactory;
import business.controller.person.create.IPersonCreation;
import business.controller.role.EditPersonRole.IEditPersonRole;
import business.controller.role.IRoleController;
import data.interfaces.DTOs.IPersonDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.CreatePersonDialog;
import presentation.forms.EditRolesForPersons;
import presentation.tableModels.PersonTableModel;

/**
 *
 * @author Kno
 */
public class EditRolesListener implements ActionListener{
    
    JTable table;
    IControllerFactory factory;
    IRoleController roles;
    IEditPersonRole roleeditor;
    
public EditRolesListener(JTable table, IControllerFactory factory, IRoleController roles, IEditPersonRole roleeditor)
{
    this.roleeditor = roleeditor;
    this.table = table;
    this.factory = factory;
    this.roles = roles;
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie bearbeiten möchten.");
        } else {
            int index = table.convertRowIndexToModel(table.getSelectedRow());
            PersonTableModel personModel = (PersonTableModel) table.getModel();
            
            EditRolesForPersons editroles = new EditRolesForPersons(personModel.getPersonDTO(index), roles, roleeditor);
            editroles.setVisible(true);
        }
    
    }
    
}
