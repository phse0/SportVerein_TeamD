/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.TrainingTeamDTO;
import data.interfaces.DAOs.ITrainingTeamDAO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ITrainingTeam;
import data.models.TrainingTeam;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class TrainingTeamDAO extends AbstractDAO<ITrainingTeam, ITrainingTeamDTO> implements ITrainingTeamDAO{

    private static ITrainingTeamDAO instance;
    
    private TrainingTeamDAO(){
        super("data.models.TrainingTeam");
    }
    
    public static ITrainingTeamDAO getInstance(){
        if(instance == null){
            instance = new TrainingTeamDAO();
        }
        return instance;
    }
    
    @Override
    public ITrainingTeam create() {
        return new TrainingTeam();
    }
    
    @Override
    public ITrainingTeam getByName(Session s, String name) {
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE name LIKE '%"+name+"%'");
        return (ITrainingTeam) query.uniqueResult();
    }

    @Override
    public ITrainingTeamDTO extractDTO(ITrainingTeam model) {
        return new TrainingTeamDTO(model);
    }
    
}
