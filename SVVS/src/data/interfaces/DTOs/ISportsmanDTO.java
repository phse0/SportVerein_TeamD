/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ISportsman;

/**
 *
 * @author uubu
 */
public interface ISportsmanDTO extends IDTO<ISportsman>{

    IDepartmentDTO getDepartment();

    IPersonDTO getPerson();

    IRoleRightsDTO getRoleRight();

    ISportDTO getSport();

    void setDepartment(IDepartmentDTO department);

    void setPerson(IPersonDTO person);

    void setRoleRight(IRoleRightsDTO roleRight);

    void setSport(ISportDTO sport);
    
}
