/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author Michael
 */
public interface ITournamentInvite extends IModel {

    ISportsman getSportsman();

    ITournament getTournament();

    int getTournamentInviteID();

    boolean isAccepted();

    void setAccepted(boolean accepted);

    void setSportsman(ISportsman sportsman);

    void setTournament(ITournament tournament);

    void setTournamentInviteID(int tournamentInviteID);
    
}
