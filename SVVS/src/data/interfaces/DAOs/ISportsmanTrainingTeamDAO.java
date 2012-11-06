/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ISportsmanTrainingTeamDAO extends IDAOs<ISportsmanTrainingTeam, ISportsmanTrainingTeamDTO>{

    ISportsmanTrainingTeam getById(Session s, int id);

    List<ISportsmanTrainingTeam> getBySportsman(Session s, ISportsman sportsman);
    
}
