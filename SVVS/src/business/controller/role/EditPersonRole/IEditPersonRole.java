/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role.EditPersonRole;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author phil
 */
public interface IEditPersonRole extends Remote, IController {

    public List<IRoleDTO> loadRolesOfPerson(IPerson person) throws RemoteException;

    public void EditPersonRole(IPerson person, List<IRole> roles) throws RemoteException;
}
