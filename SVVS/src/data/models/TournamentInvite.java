/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ISportsman;
import data.interfaces.models.ITournament;
import data.interfaces.models.ITournamentInvite;

/**
 *
 * @author Michael
 */
public class TournamentInvite implements ITournamentInvite {

    private int tournamentInviteID;
    private ITournament tournament;
    private ISportsman sportsman;
    private boolean accepted;
    
    public TournamentInvite() {
    }

    @Override
    public int getTournamentInviteID() {
        return tournamentInviteID;
    }

    @Override
    public void setTournamentInviteID(int tournamentInviteID) {
        this.tournamentInviteID = tournamentInviteID;
    }

    @Override
    public ITournament getTournament() {
        return tournament;
    }

    @Override
    public void setTournament(ITournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public ISportsman getSportsman() {
        return sportsman;
    }

    @Override
    public void setSportsman(ISportsman sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public boolean isAccepted() {
        return accepted;
    }

    @Override
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
   
}
