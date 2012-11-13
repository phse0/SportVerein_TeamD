/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import data.interfaces.models.ISportsman;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ISportsmanDAO extends IDAOs<ISportsman, ISportsmanDTO>{

    List<ISportsman> getByPerson(Session s, IPerson person);

    ISportsman getByAll(Session s, IPerson person, IDepartment department, ISport sport);
    
}
