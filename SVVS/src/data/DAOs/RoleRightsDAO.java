/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.RoleRightsDTO;
import data.interfaces.DAOs.IRoleRightsDAO;
import data.interfaces.DTOs.IDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.models.IModel;
import data.interfaces.models.IRoleRights;
import data.models.RoleRights;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class RoleRightsDAO extends AbstractDAO<IRoleRights, IRoleRightsDTO> implements IRoleRightsDAO{

    private static IRoleRightsDAO instance;
    
    private RoleRightsDAO(){
        super("data.models.RoleRights");
    }
    
    public static IRoleRightsDAO getInstance(){
        if (instance == null){
            instance = new RoleRightsDAO();
        }
        return instance;
    }
    
    @Override
    public IRoleRights create() {
        return new RoleRights();
    }

    @Override
    public IRoleRightsDTO extractDTO(IRoleRights model) {
        return new RoleRightsDTO(model);
    }
    
}
