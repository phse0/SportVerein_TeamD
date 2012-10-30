/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import data.models.SportsmanTrainingTeam;
import data.models.TournamentInvite;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ISportsman extends IRole{

    List<SportsmanTrainingTeam> getTeams();

    void setTeams(List<SportsmanTrainingTeam> teams);

    List<ITournamentInvite> getInvites();

    void setInvites(List<ITournamentInvite> invites);

    void addInvite(ITournamentInvite invite);

    void removeInvite(TournamentInvite invite);
    
}
