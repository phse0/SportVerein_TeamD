/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ICaretakerDTO;
import data.interfaces.models.ICaretaker;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ICaretakerDAO extends IDAOs<ICaretaker, ICaretakerDTO> {

    List<ICaretaker> getByPerson(Session s, IPerson person);

    ICaretaker getByAll(Session s, IPerson person, IDepartment department);
    
}
