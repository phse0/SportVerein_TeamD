/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITournamentInvite;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Sportsman extends Role implements ISportsman{

    private List<ISportsmanTrainingTeam> teams;
    private List<ITournamentInvite> invites;
    
    public Sportsman() {
        super();
    }

    @Override
    public List<ISportsmanTrainingTeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<ISportsmanTrainingTeam> teams) {
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
    public void removeInvite(ITournamentInvite invite) {
        this.invites.remove(invite);
    }
    
    
}
