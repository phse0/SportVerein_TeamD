/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.IDepartment;
import data.interfaces.IPerson;
import data.interfaces.IRole;
import data.interfaces.IRoleRights;

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
