/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.RMI;

import business.controller.departments.IDepartmentController;
import business.controller.person.IPersonController;
import business.controller.person.create.IPersonCreation;
import business.controller.person.delete.IPersonDelete;
import business.controller.person.edit.IPersonEdit;
import business.controller.tournament.Create.ITournamentCreation;
import business.controller.tournament.ITournamentController;
import business.controller.tournament.edit.ITournamentEdit;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author phil
 */
public interface IControllerFactory extends Remote  {

    IDepartmentController loadDepartmentController() throws RemoteException;

    IPersonController loadPersonController() throws RemoteException;

    IPersonCreation loadPersonCreateController() throws RemoteException;

    IPersonEdit loadPersonEditController() throws RemoteException;

    ITournamentController loadTournamentController() throws RemoteException;

    ITournamentCreation loadTournamentCreateController() throws RemoteException;

    ITournamentEdit loadTournamentEditController() throws RemoteException;
    
    IPersonDelete loadPersonDeleteController() throws RemoteException;
    

}
