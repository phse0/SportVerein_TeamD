/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.models.IDepartment;

/**
 *
 * @author uubu
 */
public class DepartmentDTO extends AbstractDTO<IDepartment> implements IDepartmentDTO{

    protected int departmentID;
    protected String name;
              
    public DepartmentDTO(IDepartment model){
        extract(model);
    }
    
    @Override
    public void extract(IDepartment model) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
    
}
