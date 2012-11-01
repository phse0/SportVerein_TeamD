/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IMatchDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.IMatch;

/**
 *
 * @author uubu
 */
public class MatchDTO extends AbstractDTO<IMatch> implements IMatchDTO{

    private ITournamentDTO tournament;
    private String location;
    private String date;
    private ITeamDTO team1;
    private ITeamDTO team2;
    private Integer goalsTeam1;
    private Integer goalsTeam2;
    
    public MatchDTO(IMatch model){
        extract(model);
    }
    
    @Override
    public void extract(IMatch model) {
        this.id = model.getMatchID();
        this.location = model.getLocation();
        this.date = model.getDate().toString();
        this.team1 = new TeamDTO(model.getTeam1());
        this.team2 = new TeamDTO(model.getTeam2());
        this.goalsTeam1 = model.getGoalsTeam1();
        this.goalsTeam2 = model.getGoalsTeam2();
    }

    @Override
    public ITournamentDTO getTournament() {
        return tournament;
    }

    @Override
    public void setTournament(ITournamentDTO tournament) {
        this.tournament = tournament;
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
    public ITeamDTO getTeam1() {
        return team1;
    }

    @Override
    public void setTeam1(ITeamDTO team1) {
        this.team1 = team1;
    }

    @Override
    public ITeamDTO getTeam2() {
        return team2;
    }

    @Override
    public void setTeam2(ITeamDTO team2) {
        this.team2 = team2;
    }

    @Override
    public Integer getGoalsTeam1() {
        return goalsTeam1;
    }

    @Override
    public void setGoalsTeam1(Integer goalsTeam1) {
        this.goalsTeam1 = goalsTeam1;
    }

    @Override
    public Integer getGoalsTeam2() {
        return goalsTeam2;
    }

    @Override
    public void setGoalsTeam2(Integer goalsTeam2) {
        this.goalsTeam2 = goalsTeam2;
    }
    
   
    
}
