/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.models.IRole;

/**
 *
 * @author uubu
 */
public class RoleDTO extends AbstractRoleDTO<IRole> implements IRoleDTO{

    public RoleDTO(IRole model){
        if(model == null) return;
        extract(model);
    }
    
    @Override
    public void extract(IRole model) {
        extractRole(model);
    }    
}
