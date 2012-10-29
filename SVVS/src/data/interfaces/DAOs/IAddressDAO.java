/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.models.IAddress;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public interface IAddressDAO extends IDAOs<IAddress> {
    
    public List<IAddress> getByCity(Session s, String city);
    
}