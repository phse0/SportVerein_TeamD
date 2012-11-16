/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ITournament;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ITournamentDAO extends IDAOs<ITournament, ITournamentDTO>{

    ITournament getById(Session s, int id);
    
}
