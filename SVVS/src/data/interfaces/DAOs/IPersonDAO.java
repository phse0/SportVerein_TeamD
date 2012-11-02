/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public interface IPersonDAO extends IDAOs<IPerson, IPersonDTO> {
    
    public List<IPerson> getByLastName(Session s,String name);
    
    public List<IPerson> getByFirstName(Session s, String name);
    
    public List<IPerson> getLikeName(Session s,String name);

    List<IRole> getAllRoles(Session s, IPerson model);

    IPerson getById(Session s, int id);

    IPersonDTO saveDTO(Session s, IPersonDTO personDTO);

    IPerson saveDTOgetModel(Session s, IPersonDTO personDTO);
    
}
