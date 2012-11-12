/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role.EditPersonRole.state;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author phil
 */
public interface IEditPersonRoleState extends IController {

    public List<IRoleRightsDTO> loadRoleRights() throws RemoteException;

    public List<IRoleRightsDTO> loadRoleRightsOfPerson(IPersonDTO person) throws RemoteException;

    public void EditPersonRole(IPersonDTO person, List<IRoleRightsDTO> roles, IDepartmentDTO department, ISportDTO sport) throws RemoteException;
}
