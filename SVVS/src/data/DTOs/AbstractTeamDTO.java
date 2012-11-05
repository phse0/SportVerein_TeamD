/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ITeam;

/**
 *
 * @author uubu
 */
public abstract class AbstractTeamDTO<V extends ITeam> extends AbstractDTO<V> {

    protected String name;
    protected ISportDTO sport;
    protected ILeagueDTO league;

    public void extractTeam(V model) {
        this.id = model.getTeamID();
        this.name = model.getName();
        this.sport = (model.getSport() != null) ? new SportDTO(model.getSport()) : null;
        this.league = (model.getLeague() != null) ? new LeagueDTO(model.getLeague()) : null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ILeagueDTO getLeague() {
        return league;
    }

    public void setLeague(ILeagueDTO league) {
        this.league = league;
    }
    
    public ISportDTO getSport() {
        return sport;
    }

    public void setSport(ISportDTO sport) {
        this.sport = sport;
    }
//    public List<ITournamentDTO> getTournaments() {
//        return tournaments;
//    }
//
//    public void setTournaments(List<ITournamentDTO> tournaments) {
//        this.tournaments = tournaments;
//    }
}
