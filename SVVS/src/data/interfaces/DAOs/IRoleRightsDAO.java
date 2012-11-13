/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.models.IRoleRights;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface IRoleRightsDAO extends IDAOs<IRoleRights, IRoleRightsDTO>{

    IRoleRights getById(Session s, int id);
    
}
