/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.models.IPerson;
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
    
}
