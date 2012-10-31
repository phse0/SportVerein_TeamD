/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author phil
 */
public interface IControllerFactory extends Remote  {
    /**
     * @param name
     * PersonCreate for Create a new Person
     * @return 
     */
    public IController loadController(String name)  throws RemoteException ;
}
