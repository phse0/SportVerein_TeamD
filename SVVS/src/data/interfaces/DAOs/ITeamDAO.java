/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ITeamDAO extends IDAOs<ITeam, ITeamDTO>{

    List<ITeam> getBySport(Session s, ISport model);
    
}
