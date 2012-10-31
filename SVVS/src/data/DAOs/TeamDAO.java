/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ITeamDAO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.models.ITeam;
import data.models.Team;

/**
 *
 * @author uubu
 */
public class TeamDAO extends AbstractDAO<ITeam, ITeamDTO> implements ITeamDAO{

    private static ITeamDAO instance;
    
    private TeamDAO(){
        super("data.models.Team");
    }
    
    public static ITeamDAO getInstance(){
        if(instance == null){
            instance = new TeamDAO();
        }
        return instance;
    }
    
    @Override
    public ITeam create() {
        return new Team();
    }

    @Override
    public ITeamDTO extractDTO(ITeam model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
