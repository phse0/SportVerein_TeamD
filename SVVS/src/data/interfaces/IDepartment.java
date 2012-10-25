/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces;

import java.util.List;

/**
 *
 * @author uubu
 */
public interface IDepartment {

    int getDepartmentID();

    IManager getManager();

    String getName();

    List<IRole> getRoles();

    void setDepartmentID(int departmentID);

    void setManager(IManager manager);

    void setName(String name);

    void setRoles(List<IRole> roles);
    
}
