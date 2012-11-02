/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.RMI;

import business.controller.departments.DepartmentController;
import business.controller.person.PersonController;
import business.controller.person.create.PersonCreation;
import business.controller.person.edit.PersonEdit;
import business.controller.tournament.Create.TournamentCreation;
import business.controller.tournament.TournamentController;
import business.controller.tournament.edit.TournamentEdit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author phil
 */
public class ControllerFactory extends UnicastRemoteObject implements IControllerFactory {

    public ControllerFactory() throws RemoteException {
        super();
    }

    @Override
    public IController loadController(String name) throws RemoteException {
        if (name.equals("PersonCreate")) {
            return new PersonCreation();
        } else if (name.equals("PersonEdit")) {
            return new PersonEdit();
        } else if (name.equals("PersonController")) {
            return PersonController.getInstance();
        } else if (name.equals("TournamentCreate")) {
            return new TournamentCreation();
        } else if (name.equals("TournamentEdit")) {
            return new TournamentEdit();
        } else if (name.equals("TournamentController")) {
            return TournamentController.getInstance();
        } else if (name.equals("DepartmentController")) {
            return DepartmentController.getInstance();
        }

        return null;
    }

    public IController loadPersonCreateController() throws RemoteException {
        return new PersonCreation();
    }

    public IController loadPersonEditController() throws RemoteException {
        return new PersonEdit();
    }

    public IController loadPersonController() throws RemoteException {
        return PersonController.getInstance();
    }

    public IController loadTournamentCreateController() throws RemoteException {
        return new TournamentCreation();
    }
    
    public IController loadTournamentEditController() throws RemoteException {
        return new TournamentEdit();
    }
    
    public IController loadTournamentController() throws RemoteException {
        return TournamentController.getInstance();
    }
    
    public IController laodDepartmentController() throws RemoteException {
        return DepartmentController.getInstance();
    }
}
