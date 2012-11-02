/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.ISport;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface IRoleDAO extends IDAOs<IRole, IRoleDTO> {

    List<IRole> getBySportAndPerson(Session s, ISport sport, IPerson person);

    List<IRole> getByPerson(Session s, IPerson person);

    List<IRole> getBySport(Session s, ISport sport);
    
}
