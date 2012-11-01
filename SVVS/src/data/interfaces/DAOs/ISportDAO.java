/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ISport;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ISportDAO extends IDAOs<ISport, ISportDTO>{

    ISport getByName(Session s, String name);
    
}
