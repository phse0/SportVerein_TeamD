/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ISport;

/**
 *
 * @author uubu
 */
public class SportDTO extends AbstractDTO<ISport> implements ISportDTO {

    private String name;
    private int maxPlayers;
   // private List<ITeamDTO> teams;

    public SportDTO(ISport model) {
        if(model == null) return;
        extract(model);
    }

    @Override
    public void extract(ISport model) {
        this.id = model.getSportID();
        this.name = model.getName();

//        for (ITeam team : model.getTeams()) {
//            //teams.add(new TeamDTO(team));
//        }
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
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

//    @Override
//    public List<ITeamDTO> getTeams() {
//        return teams;
//    }
//
//    @Override
//    public void setTeams(List<ITeamDTO> teams) {
//        this.teams = teams;
//    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {

        if (((ISportDTO) obj).getName().equals(this.getName())) {

            return true;
        }
        return false;
    }
}
