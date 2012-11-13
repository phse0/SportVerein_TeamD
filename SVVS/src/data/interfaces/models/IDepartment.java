/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import java.util.List;

/**
 *
 * @author uubu
 */
public interface IDepartment extends IModel {

    int getDepartmentID();

    IManager getManager();

    String getName();

    List<IRole> getRoles();

    void setDepartmentID(int departmentID);

    void setManager(IManager manager);

    void setName(String name);

    void setRoles(List<IRole> roles);

    void addSports(ISport sport);

    List<ISport> getSports();

    void removeSports(ISport sport);

    void setSports(List<ISport> sports);
    
}
