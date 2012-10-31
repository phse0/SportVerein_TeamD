/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IAdministratorDTO;
import data.interfaces.models.IAdministrator;

/**
 *
 * @author uubu
 */
public class AdministratorDTO extends AbstractRoleDTO<IAdministrator> implements IAdministratorDTO {

    public AdministratorDTO(IAdministrator model) {
        extract(model);
    }

    @Override
    public void extract(IAdministrator model) {
        extractRole(model);
        //zusätzliche Entitäten hier dazufügen
    }
    
   
    
   
    
    
    
}
