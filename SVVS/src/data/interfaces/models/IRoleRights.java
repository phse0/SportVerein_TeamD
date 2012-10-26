/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface IRoleRights {

    String getName();

    int getRight();

    int getRoleRightsID();

    void setName(String name);

    void setRight(int right);

    void setRoleRightsID(int roleRightsID);
    
}
