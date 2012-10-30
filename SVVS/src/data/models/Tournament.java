/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import data.interfaces.models.ITournamentInvite;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Tournament implements ITournament {
    
    private int tournamentID;
    private String name;
    private String location;
    private Date date;
    private BigDecimal fee;
    private List<ITeam> teams;
    private List<IMatch> matches;
    private List<ITournamentInvite> invites;

    public Tournament() {
    }

    public Tournament(String name) {
        this.name = name;
    }

    @Override
    public int getTournamentID() {
        return tournamentID;
    }

    @Override
    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<ITeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<ITeam> teams) {
        this.teams = teams;
    }

    @Override
    public List<IMatch> getMatches() {
        return matches;
    }

    @Override
    public void setMatches(List<IMatch> matches) {
        this.matches = matches;
    }
    
    @Override
    public void addTeam(ITeam team) {
        this.teams.add(team);
    }
    
    @Override
    public void removeTeam(ITeam team) {
        this.teams.remove(team);
    }
    
    @Override
    public void addMatch(IMatch match) {
        this.matches.add(match);
    }
    
    @Override
    public void removeMatch(IMatch match) {
        this.matches.add(match);
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public BigDecimal getFee() {
        return fee;
    }

    @Override
    public void setFee(BigDecimal fee) {
        this.fee = fee;
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
