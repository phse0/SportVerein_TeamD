/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IMatchDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author uubu
 */
public class TournamentDTO extends AbstractDTO<ITournament> implements ITournamentDTO {

    private String name;
    private String location;
    private String date;
    private double fee;
    private List<ITeamDTO> teams;
    private List<IMatchDTO> matches;
    private ISportDTO sport;
    private boolean finished;

    public TournamentDTO(ITournament model) {
        if(model == null) return;
        teams = new LinkedList<>();
        matches = new LinkedList<>();
        extract(model);
    }

    @Override
    public void extract(ITournament model) {
        this.id = model.getTournamentID();
        this.name = model.getName();
        this.date = model.getDate().toString();
        this.fee = (model.getFee() != null) ? model.getFee().doubleValue() : 0;
        this.location = model.getLocation();
        this.sport = new SportDTO(model.getSport());
        this.finished = model.isFinished();

        if (model.getTeams() != null) {
            for (ITeam team : model.getTeams()) {
                teams.add(new TeamDTO(team));
            }
        }

        if (model.getMatches() != null) {
            for (IMatch match : model.getMatches()) {
                matches.add(new MatchDTO(match));
            }
        }

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
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public double getFee() {
        return fee;
    }

    @Override
    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public List<ITeamDTO> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<ITeamDTO> teams) {
        this.teams = teams;
    }

    @Override
    public List<IMatchDTO> getMatches() {
        return matches;
    }

    @Override
    public void setMatches(List<IMatchDTO> matches) {
        this.matches = matches;
    }

    @Override
    public ISportDTO getSport() {
        return sport;
    }

    @Override
    public void setSport(ISportDTO sport) {
        this.sport = sport;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    
    
}
