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

    IController loadDepartmentController() throws RemoteException;

    IController loadPersonController() throws RemoteException;

    IController loadPersonCreateController() throws RemoteException;

    IController loadPersonEditController() throws RemoteException;

    IController loadTournamentController() throws RemoteException;

    IController loadTournamentCreateController() throws RemoteException;

    IController loadTournamentEditController() throws RemoteException;
    

}
