/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IRightDTO;
import data.interfaces.models.IRight;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface IRightDAO extends IDAOs<IRight, IRightDTO>{

    Long getRightbyName(Session s, String name);
    
}
