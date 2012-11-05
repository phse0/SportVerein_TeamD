/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author phil
 */
public abstract class AController extends UnicastRemoteObject implements IController{
    public AController() throws RemoteException{
        super();
    }
}
