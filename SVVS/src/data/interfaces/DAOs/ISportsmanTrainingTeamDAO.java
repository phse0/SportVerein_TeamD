/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.models.ISportsmanTrainingTeam;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ISportsmanTrainingTeamDAO extends IDAOs<ISportsmanTrainingTeam, ISportsmanTrainingTeamDTO>{

    ISportsmanTrainingTeam getById(Session s, int id);
    
}
