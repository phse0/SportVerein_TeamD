/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role.EditPersonRole;

import business.controller.RMI.AController;
import business.controller.departments.DepartmentController;
import business.controller.person.edit.States.IPersonEditState;
import business.controller.person.edit.States.PersonEditLoadCountryState;
import business.controller.role.EditPersonRole.state.EditPersonRoleLoadState;
import business.controller.role.EditPersonRole.state.IEditPersonRoleState;
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
 * first load PersonRole
 * Second editpersonrole
 * @author phil
 */
public class EditPersonRole extends AController  implements IEditPersonRole{

    IEditPersonRoleState _state;

    public IEditPersonRoleState getState() {
        return _state;
    }

    public void setState(IEditPersonRoleState _state) {
        this._state = _state;
    }

    public EditPersonRole() throws RemoteException {
        super();
        setState(new EditPersonRoleLoadState(this));
    }
    
    @Override
    public List<IRoleRightsDTO> loadRoleRightsOfPerson(IPersonDTO person) throws RemoteException {
        return _state.loadRoleRightsOfPerson(person);
    }

    @Override
    public void EditPersonRole(IPersonDTO person, List<IRoleRightsDTO> roles, IDepartmentDTO department, ISportDTO sport) throws  RemoteException{
        _state.EditPersonRole(person, roles, department, sport);
    }

    @Override
    public List<IDepartmentDTO> loadDepartments() throws RemoteException {
       return DepartmentController.getInstance().loadDepartments();
    }

    @Override
    public List<IRoleRightsDTO> loadRoleRights() throws RemoteException {
        return _state.loadRoleRights();
    }

    @Override
    public List<IRoleDTO> loadRolesOfPerson(IPersonDTO person) throws RemoteException {
      return RoleController.getInstance().loadRolesOfPerson(person);
    }
    
}
