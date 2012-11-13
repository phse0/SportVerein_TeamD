/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.IRole;

/**
 *
 * @author uubu
 */
public abstract class AbstractRoleDTO<V extends IRole> extends AbstractDTO<V> {

    protected IPersonDTO person;
    protected IRoleRightsDTO roleRight;
    protected IDepartmentDTO department;
    protected ISportDTO sport;

    public void extractRole(V model) {
        if (model == null){
            return;
        }
        this.id = model.getRoleID();
        this.person = new PersonDTO(model.getPerson());
        this.roleRight = new RoleRightsDTO(model.getRoleRight());
        this.department = new DepartmentDTO(model.getDepartment());
        this.sport = new SportDTO(model.getSport());
        
    }
    
    public IPersonDTO getPerson() {
        return person;
    }

    public void setPerson(IPersonDTO person) {
        this.person = person;
    }

    public IRoleRightsDTO getRoleRight() {
        return roleRight;
    }

    public void setRoleRight(IRoleRightsDTO roleRight) {
        this.roleRight = roleRight;
    }

    public IDepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(IDepartmentDTO department) {
        this.department = department;
    }

    public ISportDTO getSport() {
        return sport;
    }

    public void setSport(ISportDTO sport) {
        this.sport = sport;
    }
}
