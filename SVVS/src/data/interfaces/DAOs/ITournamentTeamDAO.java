/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ITournamentTeamDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITournamentTeam;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ITournamentTeamDAO extends IDAOs<ITournamentTeam, ITournamentTeamDTO>{
    
    public List<ITournamentTeam> getBySport(Session s, ISport model);
    
}
