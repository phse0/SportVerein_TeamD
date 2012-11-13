/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.CoachDTO;
import data.interfaces.DAOs.ICoachDAO;
import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.models.ICoach;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.ISport;
import data.models.Coach;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class CoachDAO extends AbstractDAO<ICoach, ICoachDTO> implements ICoachDAO {

    private static ICoachDAO instance;
    
    private CoachDAO() {
        super("data.models.Coach");
    }
    
    public static ICoachDAO getInstance(){
        if ( instance == null){
            instance = new CoachDAO();
        }
        return instance;
    }
    
    @Override
    public ICoach create() {
        return new Coach();
    }

    @Override
    public ICoachDTO extractDTO(ICoach model) {
        return new CoachDTO(model);
    }
    
    
     @Override
    public List<ICoach> getByPerson(Session s,IPerson person){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person");
        query.setParameter("person", person);
        List<ICoach> roles = new LinkedList<>();
        roles = query.list();
        
        if (roles.isEmpty()){
            return null;
        }
        
        return roles;
                
    }
     
      @Override
    public ICoach getByAll(Session s,IPerson person, IDepartment department, ISport sport){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person AND department = :department AND sport = :sport");
        query.setParameter("person", person);
        query.setParameter("department", department);
        query.setParameter("sport", sport);
        
        return (ICoach) query.uniqueResult();
                
    }
}
