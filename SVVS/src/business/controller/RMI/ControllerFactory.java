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
    public IController loadPersonCreateController() throws RemoteException {
        return new PersonCreation();
    }

    @Override
    public IController loadPersonEditController() throws RemoteException {
        return new PersonEdit();
    }

    @Override
    public IController loadPersonController() throws RemoteException {
        return PersonController.getInstance();
    }

    @Override
    public IController loadTournamentCreateController() throws RemoteException {
        return new TournamentCreation();
    }
    
    @Override
    public IController loadTournamentEditController() throws RemoteException {
        return new TournamentEdit();
    }
    
    @Override
    public IController loadTournamentController() throws RemoteException {
        return TournamentController.getInstance();
    }
    
    @Override
    public IController loadDepartmentController() throws RemoteException {
        return DepartmentController.getInstance();
    }
}
