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

    protected String name;
              
    public DepartmentDTO(IDepartment model){
        extract(model);
    }
    
    @Override
    public void extract(IDepartment model) {
        this.id = model.getDepartmentID();
        this.name = model.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
}
