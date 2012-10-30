/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.models.ITrainingTeam;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ITrainingTeamDAO extends IDAOs<ITrainingTeam>{

    ITrainingTeam getByName(Session s, String name);
    
}
