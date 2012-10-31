/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IDepartment;

/**
 *
 * @author uubu
 */
public interface IDepartmentDTO extends IDTO<IDepartment> {

    int getDepartmentID();

    String getName();

    void setDepartmentID(int departmentID);

    void setName(String name);
}
