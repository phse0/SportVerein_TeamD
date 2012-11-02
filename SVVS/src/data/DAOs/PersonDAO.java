/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.PersonDTO;
import data.interfaces.DAOs.IPersonDAO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.models.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public class PersonDAO extends AbstractDAO<IPerson, IPersonDTO> implements IPersonDAO {

    private static IPersonDAO instance;
    
    public static IPersonDAO getInstance() {
        if(instance == null) {
            instance = new PersonDAO();
        }
        return instance;
    }
    
    private PersonDAO() {
        super("data.models.Person");
    }
    
    @Override
    public IPerson create() {
        return new Person();
    }

    @Override
    public List<IRole> getAllRoles(Session s, IPerson model){
        
        Query query = s.createQuery("From" + "data.models.Role" + "WHERE person = :model");
        query.setParameter("model", model);
        return query.list(); 
    }
    
    @Override
    public List<IPerson> getLikeName(Session s,String name) {
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE firstname LIKE '%"+name+"%' "
                + "OR lastname LIKE '%"+name+"%'");
        return query.list();
    }

    @Override
    public List<IPerson> getByLastName(Session s,String name) {
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE lastname = :lname");
        query.setString("lname", name);
        return query.list();        
    }

    @Override
    public List<IPerson> getByFirstName(Session s,String name) {
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE firstname = :fname");
        query.setString("fname", name);
        return query.list();    
    }

    @Override
    public IPersonDTO extractDTO(IPerson model) {
        return new PersonDTO(model);
    }

}
