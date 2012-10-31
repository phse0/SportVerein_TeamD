/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ICaretakerDTO;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ICaretaker;

/**
 *
 * @author uubu
 */
public class CaretakerDTO extends AbstractDTO<ICaretaker> implements ICaretakerDTO{

    protected IPersonDTO person;
    protected IRoleRightsDTO roleRight;
    protected IDepartmentDTO department;
    protected ISportDTO sport;

    @Override
    public void extract(ICaretaker model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     public IPersonDTO getPerson() {
        return person;
    }

    public void setPerson(IPersonDTO person) {
        this.person = person;
    }

    public IRoleRightsDTO getRoleRight() {
        return roleRight;
    }

    public void setRoleRight(IRoleRightsDTO roleRight) {
        this.roleRight = roleRight;
    }

    public IDepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(IDepartmentDTO department) {
        this.department = department;
    }

    public ISportDTO getSport() {
        return sport;
    }

    public void setSport(ISportDTO sport) {
        this.sport = sport;
    }
    
}
