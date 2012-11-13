/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.RoleDTO;
import data.interfaces.DAOs.IRoleDAO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRight;
import data.interfaces.models.IRole;
import data.interfaces.models.ISport;
import data.models.Role;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class RoleDAO extends AbstractDAO<IRole, IRoleDTO> implements IRoleDAO{
    
    private static IRoleDAO instance;
    
    private RoleDAO(){
        super("data.models.Role");
    }
    
    public static IRoleDAO getInstance(){
        if (instance == null){
            instance = new RoleDAO();
        }
        return instance;
    }

    @Override
    public IRole create() {
        return new Role();
    }

    @Override
    public IRoleDTO extractDTO(IRole model) {
        return new RoleDTO(model);
    }
    
    public List<IRole> getBySportAndPerson(Session s,ISport sport, IPerson person){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person AND sport =:sport");
        query.setParameter("person", person);
        query.setParameter("sport", sport);
        List<IRole> roles = new LinkedList<>();
        roles = query.list();
        
        if (roles.isEmpty()){
            return null;
        }
        
        return roles;
                
    }
    
    @Override
    public List<IRole> getBySport(Session s,ISport sport){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE  sport =:sport");
        query.setParameter("sport", sport);
        List<IRole> roles = new LinkedList<>();
        roles = query.list();
        
        if (roles.isEmpty()){
            return null;
        }
        
        return roles;
                
    }
    @Override
    public List<IRole> getByPerson(Session s,IPerson person){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person");
        query.setParameter("person", person);
        List<IRole> roles = new LinkedList<>();
        roles = query.list();
        
        if (roles.isEmpty()){
            return null;
        }
        
        return roles;
                
    }
    
     @Override
    public IRole getByAll(Session s,IPerson person, IDepartment department, ISport sport){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person AND department = :department AND sport = :sport");
        query.setParameter("person", person);
        query.setParameter("department", department);
        query.setParameter("sport", sport);
        
        return (IRole) query.uniqueResult();
                
    }
}
