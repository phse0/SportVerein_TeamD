/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IManagerDTO;
import data.interfaces.models.IManager;
import data.interfaces.models.IPerson;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface IManagerDAO extends IDAOs<IManager, IManagerDTO>{

    List<IManager> getByPerson(Session s, IPerson person);
    
}
