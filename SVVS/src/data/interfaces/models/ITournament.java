/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import data.models.Sport;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ITournament extends IModel {

    void addMatch(IMatch match);

    void addTeam(ITeam team);

    List<IMatch> getMatches();

    String getName();

    List<ITeam> getTeams();

    int getTournamentID();

    void removeMatch(IMatch match);

    void removeTeam(ITeam team);

    void setMatches(List<IMatch> matches);

    void setName(String name);

    void setTeams(List<ITeam> teams);

    void setTournamentID(int tournamentID);

    Date getDate();

    String getLocation();

    void setDate(Date date);

    void setLocation(String location);

    BigDecimal getFee();

    void setFee(BigDecimal fee);

    List<ITournamentInvite> getInvites();

    void setInvites(List<ITournamentInvite> invites);

    void addInvite(ITournamentInvite invite);

    void removeInvite(ITournamentInvite invite);

    Sport getSport();

    void setSport(Sport sport);
    
}
