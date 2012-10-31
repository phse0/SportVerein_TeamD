/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IRoleDAO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.models.IRole;
import data.models.Role;

/**
 *
 * @author uubu
 */
public class RoleDAO extends AbstractDAO<IRole, IRoleDTO> implements IRoleDAO{
    
    private static IRoleDAO instance;
    
    private RoleDAO(){
        super("data.models.Role");
    }
    
    public static IRoleDAO getInstance(){
        if (instance == null){
            instance = new RoleDAO();
        }
        return instance;
    }

    @Override
    public IRole create() {
        return new Role();
    }

    @Override
    public IRoleDTO extractDTO(IRole model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
