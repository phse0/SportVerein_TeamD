/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.models.ILeague;

/**
 *
 * @author uubu
 */
public class LeagueDTO extends AbstractDTO<ILeague> implements ILeagueDTO{

    private String name;
  //  private List<ITeamDTO> teams;
    
    public LeagueDTO(ILeague model){
        extract(model);
    }
   
    @Override
    public void extract(ILeague model) {
        this.id = model.getLeagueID();
        this.name = model.getName();
        
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
   
}
