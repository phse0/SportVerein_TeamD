/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
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
    public List<IRoleRightsDTO> loadRoles() throws RemoteException;
    public List<IRoleRightsDTO> loadRolesOfPerson(IPersonDTO person)throws RemoteException;
    public void EditPersonRole(IPerson person, List<IRole> roles) throws  RemoteException;
}
