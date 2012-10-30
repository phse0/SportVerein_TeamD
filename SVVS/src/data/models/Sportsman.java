/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ISportsman;
import data.interfaces.models.ITournamentInvite;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Sportsman extends Role implements ISportsman{

    private List<SportsmanTrainingTeam> teams;
    private List<ITournamentInvite> invites;
    
    public Sportsman() {
        super();
    }

    @Override
    public List<SportsmanTrainingTeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<SportsmanTrainingTeam> teams) {
        this.teams = teams;
    }

    @Override
    public List<ITournamentInvite> getInvites() {
        return invites;
    }

    @Override
    public void setInvites(List<ITournamentInvite> invites) {
        this.invites = invites;
    }
    
    @Override
    public void addInvite(ITournamentInvite invite) {
        this.invites.add(invite);
    }
    
    @Override
    public void removeInvite(TournamentInvite invite) {
        this.invites.remove(invite);
    }
    
    
}
