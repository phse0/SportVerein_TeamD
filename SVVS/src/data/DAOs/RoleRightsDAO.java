/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IRoleRightsDAO;
import data.interfaces.models.IRoleRights;
import data.models.RoleRights;

/**
 *
 * @author uubu
 */
public class RoleRightsDAO extends AbstractDAO<IRoleRights> implements IRoleRightsDAO{

    private static RoleRightsDAO instance;
    
    private RoleRightsDAO(){
        super("data.models.RoleRights");
    }
    
    public static RoleRightsDAO getInstance(){
        if (instance == null){
            instance = new RoleRightsDAO();
        }
        return instance;
    }
    
    @Override
    public IRoleRights create() {
        return new RoleRights();
    }
    
}
