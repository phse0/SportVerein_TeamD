/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IAdministratorDTO;
import data.interfaces.models.IAdministrator;
import data.interfaces.models.IPerson;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface IAdministratorDAO extends IDAOs<IAdministrator, IAdministratorDTO>{

    List<IAdministrator> getByPerson(Session s, IPerson person);
    
}
