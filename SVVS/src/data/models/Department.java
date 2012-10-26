/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IDepartment;
import data.interfaces.models.IManager;
import data.interfaces.models.IRole;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Department implements IDepartment{
    
    protected int departmentID;
    protected String name;
    protected List<IRole> roles;
    protected IManager manager;

    public Department() {
    }
    
    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IRole> getRoles() {
        return roles;
    }

    public void setRoles(List<IRole> roles) {
        this.roles = roles;
    }

    public IManager getManager() {
        return manager;
    }

    public void setManager(IManager manager) {
        this.manager = manager;
    }
    
    
}
