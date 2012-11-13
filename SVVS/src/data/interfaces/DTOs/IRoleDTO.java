/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IRole;

/**
 *
 * @author uubu
 */
public interface IRoleDTO extends IDTO<IRole>{
    
     public IRoleRightsDTO getRoleRight();
     public void setRoleRight(IRoleRightsDTO roleRight);
     public IDepartmentDTO getDepartment();
     public void setDepartment(IDepartmentDTO department);
     public ISportDTO getSport();
     public void setSport(ISportDTO sport);
    
}
