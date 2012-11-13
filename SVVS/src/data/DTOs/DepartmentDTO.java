/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.ISport;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author uubu
 */
public class DepartmentDTO extends AbstractDTO<IDepartment> implements IDepartmentDTO{

    protected String name;
    protected List<ISportDTO> sports;          
    
    public DepartmentDTO(IDepartment model){
        if(model == null) return;
        sports = new LinkedList<>();
        extract(model);
    }
    
    @Override
    public void extract(IDepartment model) {
        this.id = model.getDepartmentID();
        this.name = model.getName();
        for(ISport sp: model.getSports()){
            sports.add(new SportDTO(sp));
        }
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

    @Override
    public List<ISportDTO> getSports() {
        return sports;
    }

    @Override
    public void setSports(List<ISportDTO> sports) {
        this.sports = sports;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DepartmentDTO other = (DepartmentDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
}
