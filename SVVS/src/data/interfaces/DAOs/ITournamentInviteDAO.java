/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ITournament;
import data.interfaces.models.ITournamentInvite;
import data.interfaces.models.ITrainingTeam;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface ITournamentInviteDAO extends IDAOs<ITournamentInvite, ITournamentInviteDTO>{

    List<ITournamentInvite> getBySportsman(Session s, ISportsman sportsman);

    List<ITournamentInvite> getByTournament(Session s, ITournament tournament);

    List<ITournamentInvite> getByTournamentAndTeam(Session s, ITournament tournament, ITrainingTeam team);

    List<ITournamentInvite> getTeamsOfTournament(Session s, ITournament tournament);
    
}
