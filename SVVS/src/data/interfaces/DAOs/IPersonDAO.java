/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.models.IPerson;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface IPersonDAO extends IDAOs<IPerson> {
    
    public List<IPerson> getByLastName(String name);
    
    public List<IPerson> getByFirstName(String name);
    
    public List<IPerson> getLikeName(String name);
    
}
