/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ITournament;

/**
 *
 * @author uubu
 */
public class TournamentDTO extends AbstractDTO<ITournament> implements ITournamentDTO{

    private String name;
    private String location;
    private String date;
    private double fee;
    //private List<ITeamDTO> teams;
   // private List<IMatchDTO> matches;
    //private List<ITournamentInviteDTO> invites;
    
    public TournamentDTO(ITournament model){
        extract(model);
    }
    
    @Override
    public void extract(ITournament model) {
        this.id = model.getTournamentID();
        this.name = model.getName();
        this.date = model.getDate().toString();
        this.fee = model.getFee().doubleValue();
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
   
}
