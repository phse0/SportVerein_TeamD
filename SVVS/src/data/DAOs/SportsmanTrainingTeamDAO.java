/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.SportsmanTrainingTeamDTO;
import data.interfaces.DAOs.ISportsmanTrainingTeamDAO;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITrainingTeam;
import data.models.SportsmanTrainingTeam;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class SportsmanTrainingTeamDAO extends AbstractDAO<ISportsmanTrainingTeam, ISportsmanTrainingTeamDTO> implements ISportsmanTrainingTeamDAO{

    private static ISportsmanTrainingTeamDAO instance;
    
    private SportsmanTrainingTeamDAO(){
        super("data.models.SportsmanTrainingTeam");
    }
    
    public static ISportsmanTrainingTeamDAO getInstance(){
        if(instance == null){
            instance = new SportsmanTrainingTeamDAO();
        }
        return instance;
    }
    
    @Override
    public ISportsmanTrainingTeam create() {
        return new SportsmanTrainingTeam();
    }

    @Override
    public ISportsmanTrainingTeamDTO extractDTO(ISportsmanTrainingTeam model) {
        return new SportsmanTrainingTeamDTO(model);
    }
    
    @Override
    public ISportsmanTrainingTeam getById(Session s, int id){
        
        Query query = s.createQuery("FROM " + getTable() + " where sportsmanTrainingTeamID =:id");
        query.setInteger("id", id);
        return (ISportsmanTrainingTeam)query.uniqueResult();
    }
    
    @Override
    public List<ISportsmanTrainingTeam> getBySportsman(Session s, ISportsman sportsman){
        
        Query query = s.createQuery("FROM " + getTable() + " where sportsman = :sportsman");
        query.setParameter("sportsman", sportsman);
        return query.list();
    }
    

    public ISportsmanTrainingTeam getBySportsmanAndTeam(Session s, ISportsman sportsman, ITrainingTeam team){
        
        Query query = s.createQuery("FROM " + getTable() + " where sportsman = :sportsman AND team = :team");
        query.setParameter("sportsman", sportsman);
        query.setParameter("team", team);
        return (ISportsmanTrainingTeam)query.uniqueResult();
    }
    
    public ISportsmanTrainingTeam getBySportsmanAndTeamDTO(Session s, ISportsmanDTO sportsman, ITrainingTeamDTO team){
        
        ISportsman sm = SportsmanDAO.getInstance().getById(s, sportsman.getId());
        ITrainingTeam tt = TrainingTeamDAO.getInstance().getById(s, team.getId());
        
        return getBySportsmanAndTeam(s, sm, tt);
    }
    
}
