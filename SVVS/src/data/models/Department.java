/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IDepartment;
import data.interfaces.models.IManager;
import data.interfaces.models.IRole;
import data.interfaces.models.ISport;
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
    protected List<ISport> sports;

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

    public List<ISport> getSports() {
        return sports;
    }

    public void setSports(List<ISport> sports) {
        this.sports = sports;
    }
    
    public void addSports(ISport sport) {
        this.sports.add(sport);
    }
    public void removeSports(ISport sport) {
        this.sports.remove(sport);
    }
    
}
