/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public interface IRoleController extends Remote, IController  {
    public List<IRoleDTO> loadRoles() throws RemoteException;
    public List<IRoleDTO> loadRolesOfPerson(IPerson person)throws RemoteException;
    public void EditPersonRole(IPerson person, List<IRole> roles) throws  RemoteException;
}
