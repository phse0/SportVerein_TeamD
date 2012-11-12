/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IRoleRights;

/**
 *
 * @author uubu
 */
public class RoleRights implements IRoleRights{
    
    protected int roleRightsID;
    protected String name;
    protected Long right;

    public RoleRights() {
    }
    
    public int getRoleRightsID() {
        return roleRightsID;
    }

    public void setRoleRightsID(int roleRightsID) {
        this.roleRightsID = roleRightsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRight() {
        return right;
    }

    public void setRight(Long right) {
        this.right = right;
    }


    
    
}
