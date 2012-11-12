/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.ISport;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface IDepartmentDAO extends IDAOs<IDepartment, IDepartmentDTO>{

    IDepartment getBySport(Session s, ISport model);
    
}
