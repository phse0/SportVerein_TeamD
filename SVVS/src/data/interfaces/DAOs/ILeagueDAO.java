/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.models.ILeague;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ILeagueDAO extends IDAOs<ILeague, ILeagueDTO>{

    ILeague getByName(Session s, String name);
    
}
