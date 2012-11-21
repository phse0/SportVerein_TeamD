/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.messages.jms;

import business.messages.jms.interfaces.ITournamentInviteMessage;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;

/**
 *
 * @author uubu
 */
public class TournamentInviteMessage implements ITournamentInviteMessage {

    private ISportsmanDTO sportsman;
    private ITournamentDTO tournament;
    private ITrainingTeamDTO team;

    public TournamentInviteMessage(ISportsmanDTO sportsman, ITournamentDTO tournament, ITrainingTeamDTO team) {
        this.sportsman = sportsman;
        this.tournament = tournament;
        this.team = team;
    }

    @Override
    public ISportsmanDTO getSportsman() {
        return this.sportsman;
    }

    @Override
    public ITrainingTeamDTO getTeam() {
        return this.team;
    }

    @Override
    public ITournamentDTO getTournament() {
        return this.tournament;
    }

    @Override
    public String getText() {
        return "Sie wurden mit dem Team " + getTeam() +" zum Wettkampf " + getTournament() + " eingeladen!";
    }
}
