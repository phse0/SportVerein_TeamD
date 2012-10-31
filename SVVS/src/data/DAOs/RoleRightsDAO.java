/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

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
    public List getAll(Session s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List getAllDTO(Session s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IRoleRightsDTO extractDTO(IRoleRights model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
