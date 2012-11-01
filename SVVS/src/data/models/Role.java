/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.IRoleRights;
import data.interfaces.models.ISport;

/**
 *
 * @author uubu
 */
public class Role implements IRole {
    
    protected int roleID;
    protected IPerson person;
    protected IRoleRights roleRight;
    protected IDepartment department;
    protected ISport sport;
    
    @Override
    public int getRoleID() {
        return roleID;
    }

    @Override
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public IPerson getPerson() {
        return person;
    }

    @Override
    public void setPerson(IPerson person) {
        this.person = person;
    }

    @Override
    public IRoleRights getRoleRight() {
        return roleRight;
    }

    @Override
    public void setRoleRight(IRoleRights roleRight) {
        this.roleRight = roleRight;
    }

    @Override
    public IDepartment getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(IDepartment department) {
        this.department = department;
    }
    
    @Override
    public String getPersonName() {
        return this.person.getName();
    }

    @Override
    public ISport getSport() {
        return this.sport;
    }

    @Override
    public void setSport(ISport sport) {
        this.sport = sport;
    }
}
