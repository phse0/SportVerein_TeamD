/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.ManagerDTO;
import data.interfaces.DAOs.IManagerDAO;
import data.interfaces.DTOs.IManagerDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IManager;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.ISport;
import data.models.Manager;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class ManagerDAO extends AbstractDAO<IManager, IManagerDTO> implements IManagerDAO {

    private static IManagerDAO instance;
    
    private ManagerDAO(){
        super("data.models.Manager");
    }
    
    public static IManagerDAO getInstance(){
        if(instance == null){
            instance = new ManagerDAO();
        }
        return instance;
    }
    
    @Override
    public IManager create() {
        return new Manager();
    }

    @Override
    public IManagerDTO extractDTO(IManager model) {
        return new ManagerDTO(model);
    }
    
     @Override
    public List<IManager> getByPerson(Session s,IPerson person){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person");
        query.setParameter("person", person);
        List<IManager> roles = new LinkedList<>();
        roles = query.list();
        
        if (roles.isEmpty()){
            return null;
        }
        
        return roles;        
    }
     
      @Override
    public IManager getByAll(Session s,IPerson person, IDepartment department){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person AND department = :department");
        query.setParameter("person", person);
        query.setParameter("department", department);
        
        return (IManager) query.uniqueResult();
                
    }
}
