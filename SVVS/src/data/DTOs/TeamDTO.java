/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.models.ITeam;

/**
 *
 * @author uubu
 */
public class TeamDTO extends AbstractTeamDTO<ITeam> implements ITeamDTO{

    public TeamDTO(ITeam model){
        extract(model);
    }
    
    @Override
    public void extract(ITeam model) {
        extractTeam(model);
    }
 
}
