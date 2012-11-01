/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import business.controller.RMI.IControllerFactory;
import business.controller.person.create.IPersonCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import presentation.forms.CreatePersonDialog;

/**
 *
 * @author Kno
 */
public class CreateNewPersonListener implements ActionListener {

    IControllerFactory controllerfactory;

    public CreateNewPersonListener(IControllerFactory factory) {
        this.controllerfactory = factory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            IPersonCreation createController;
            createController = (IPersonCreation) controllerfactory.loadController("PersonCreate");
            new CreatePersonDialog(null, true, createController).setVisible(true);
        } catch (RemoteException ex) {
            System.out.println("Coud not load controller");
        }



    }
}
