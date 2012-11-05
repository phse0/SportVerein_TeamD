/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.models.IRoleRights;

/**
 *
 * @author uubu
 */
public class RoleRightsDTO extends AbstractDTO<IRoleRights> implements IRoleRightsDTO {

    protected String name;
    protected int right;
    
    public RoleRightsDTO(IRoleRights model){
        extract(model);
    }
    
    @Override
    public void extract(IRoleRights model) {
        
        //this.id = model.getRoleRightsID();
        this.name = model.getName();
        this.right = model.getRight();
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
    public int getRight() {
        return right;
    }

    @Override
    public void setRight(int right) {
        this.right = right;
    }
    
}
