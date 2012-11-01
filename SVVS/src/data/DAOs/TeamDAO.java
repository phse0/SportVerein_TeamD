/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.TeamDTO;
import data.interfaces.DAOs.ITeamDAO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.models.Team;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

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
        return new TeamDTO(model);
    }
    
    @Override
    public List<ITeam> getBySport(Session s,ISport model) {
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE sport = model");
        return query.list();    
    }
    
}
