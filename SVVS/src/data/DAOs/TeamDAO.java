/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ITeamDAO;
import data.interfaces.models.ITeam;
import data.models.Team;

/**
 *
 * @author uubu
 */
public class TeamDAO extends AbstractDAO<ITeam> implements ITeamDAO{

    private static TeamDAO instance;
    
    private TeamDAO(){
        super("data.models.Team");
    }
    
    public static TeamDAO getInstance(){
        if(instance == null){
            instance = new TeamDAO();
        }
        return instance;
    }
    
    @Override
    public ITeam create() {
        return new Team();
    }
    
}
