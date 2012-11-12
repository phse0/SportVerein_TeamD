/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IRightDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Media Markt
 */
public interface IAuthentificationController extends Remote, IController {

    Long Authenticate(String Username, String password) throws RemoteException;

    List<IRightDTO> getAllRights() throws RemoteException;
}
