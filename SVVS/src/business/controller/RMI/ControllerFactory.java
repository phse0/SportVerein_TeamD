/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.RMI;

import business.controller.person.create.PersonCreation;
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
        }
    return null;
    }
    
}
