/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ITeam;

/**
 *
 * @author uubu
 */
public abstract class AbstractTeamDTO<V extends ITeam> extends AbstractDTO<V> {
   
    protected String name;
    protected ISportDTO sport;
   // protected List<ITournamentDTO> tournaments;
   
    public void extractTeam(V model) {
        this.id = model.getTeamID();
        this.name = model.getName();
        this.sport = new SportDTO(model.getSport());
        
//        for(ITournament tournament : model.getTournaments()){
//            tournaments.add(new TournamentDTO(tournament));
//        }
        
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ISportDTO getSport() {
//        return sport;
//    }
//
//    public void setSport(ISportDTO sport) {
//        this.sport = sport;
//    }

//    public List<ITournamentDTO> getTournaments() {
//        return tournaments;
//    }
//
//    public void setTournaments(List<ITournamentDTO> tournaments) {
//        this.tournaments = tournaments;
//    }
}
