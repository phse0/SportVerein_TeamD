/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ITournamentInvite;

/**
 *
 * @author uubu
 */
public interface ITournamentInviteDTO extends IDTO<ITournamentInvite>{

    void extract(ITournamentInvite model);

    ISportsmanDTO getSportsman();

    ITournamentDTO getTournament();

    boolean isAccepted();

    void setAccepted(boolean accepted);

    void setSportsman(ISportsmanDTO sportsman);

    void setTournament(ITournamentDTO tournament);
    
}
