/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.models.ICoach;
import data.interfaces.models.IPerson;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ICoachDAO extends IDAOs<ICoach, ICoachDTO>{

    List<ICoach> getByPerson(Session s, IPerson person);
    
}
