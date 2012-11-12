/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role.EditPersonRole;

import business.controller.RMI.AController;
import business.controller.person.edit.States.IPersonEditState;
import business.controller.person.edit.States.PersonEditLoadCountryState;
import business.controller.role.EditPersonRole.state.EditPersonRoleLoadState;
import business.controller.role.EditPersonRole.state.IEditPersonRoleState;
import data.interfaces.DTOs.IRoleDTO;
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
    public List<IRoleDTO> loadRolesOfPerson(IPerson person) throws RemoteException {
        return _state.loadRolesOfPerson(person);
    }

    @Override
    public void EditPersonRole(IPerson person, List<IRole> roles) throws RemoteException {
        _state.EditPersonRole(person, roles);
    }
    
}
