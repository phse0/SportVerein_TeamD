/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IManagerDTO;
import data.interfaces.models.IManager;

/**
 *
 * @author uubu
 */
public class ManagerDTO extends AbstractRoleDTO<IManager> implements IManagerDTO{

    public ManagerDTO(IManager model){
        if(model == null) return;
        extract(model);
    }
    
    @Override
    public void extract(IManager model) {
        extractRole(model);
    }
    
}
