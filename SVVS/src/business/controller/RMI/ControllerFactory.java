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

   public ControllerFactory() throws RemoteException{
    super();
   }
    
    @Override
    public IController loadController(String name) throws RemoteException {
        if (name.equals("PersonCreate")) {
            return new PersonCreation();
        }else if (name.equals("PersonEdit")) {
            return new PersonEdit();
        }else if (name.equals("PersonController")) {
            return PersonController.getInstance();
        }
        
        else if (name.equals("TournamentCreate")) {
            return new TournamentCreation();
        }else if (name.equals("TournamentEdit")) {
            return new TournamentEdit();
        }else if (name.equals("TournamentController")) {
            return TournamentController.getInstance();
        }
        
        else if (name.equals("DepartmentController")) {
            return DepartmentController.getInstance();
        }
                
        return null;
    }
    
}
