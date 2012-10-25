/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces;

/**
 *
 * @author uubu
 */
public interface IRole {

    IDepartment getDepartment();

    IPerson getPerson();

    int getRoleID();

    IRoleRights getRoleRight();

    void setDepartment(IDepartment department);

    void setPerson(IPerson person);

    void setRoleID(int roleID);

    void setRoleRight(IRoleRights roleRight);
    
}
