/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role.EditPersonRole.state;

import business.controller.RMI.AController;
import business.controller.role.EditPersonRole.EditPersonRole;
import business.controller.role.EditPersonRole.IEditPersonRole;
import business.controller.role.RoleController;
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
public class EditPersonRoleLoadState  extends AController implements IEditPersonRoleState{

     EditPersonRole _editor;
    public EditPersonRoleLoadState(EditPersonRole editor)throws RemoteException {
        super();
        _editor = editor;
    }

    
    @Override
    public List<IRoleRightsDTO> loadRoleRightsOfPerson(IPersonDTO person) throws RemoteException {
        _editor.setState(new EditPersonRoleState(_editor));
        return RoleController.getInstance().loadRoleRightsOfPerson(person);
    }

    @Override
    public void EditPersonRole(IPersonDTO person, List<IRoleRightsDTO> roles, IDepartmentDTO department, ISportDTO sport) throws  RemoteException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IRoleRightsDTO> loadRoleRights() throws RemoteException {
        _editor.setState(new EditPersonRoleState(_editor));
        return RoleController.getInstance().loadRoleRights();
    }

    
}
