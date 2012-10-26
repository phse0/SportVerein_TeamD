/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.IPersonDAO;
import data.interfaces.models.IPerson;
import data.models.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public class PersonDAO extends AbstractDAO<IPerson> implements IPersonDAO {

    private static PersonDAO instance;
    
    public static PersonDAO getInstance() {
        if(instance == null) {
            instance = new PersonDAO();
        }
        return instance;
    }
    
    private PersonDAO() {
        super("data.model.Person");
    }
    
    @Override
    public IPerson create() {
        return new Person();
    }

    @Override
    public List<IPerson> getLikeName(String name) {
        Session s = HibernateUtil.getCurrentSession();
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE firstname LIKE :name OR lastname LIKE :name");
        query.setString(":name", name);
        return query.list();
    }

    @Override
    public List<IPerson> getByLastName(String name) {
        Session s = HibernateUtil.getCurrentSession();
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE firstname = :lname");
        query.setString("lname", "'%"+name+"%'");
        return query.list();        
    }

    @Override
    public List<IPerson> getByFirstName(String name) {
        Session s = HibernateUtil.getCurrentSession();
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE lastname = :lname");
        query.setString("lname", name);
        return query.list();    
    }

}
