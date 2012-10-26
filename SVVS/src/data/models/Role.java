/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.IRoleRights;

/**
 *
 * @author uubu
 */
public class Role implements IRole {
    
    protected int roleID;
    protected IPerson person;
    protected IRoleRights roleRight;
    protected IDepartment department;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public IPerson getPerson() {
        return person;
    }

    public void setPerson(IPerson person) {
        this.person = person;
    }

    public IRoleRights getRoleRight() {
        return roleRight;
    }

    public void setRoleRight(IRoleRights roleRight) {
        this.roleRight = roleRight;
    }

    public IDepartment getDepartment() {
        return department;
    }

    public void setDepartment(IDepartment department) {
        this.department = department;
    }
   
}
