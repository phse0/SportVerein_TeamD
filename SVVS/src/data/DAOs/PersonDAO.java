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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    public IPerson getById(Session s, int id){
        
        Query query = s.createQuery("FROM" + getTable() + "Where personID =:id");
        query.setInteger("id", id);
        return (IPerson)query.uniqueResult();
    }
    
    @Override
    public IPersonDTO saveDTO(Session s, IPersonDTO personDTO){
        
        if (personDTO == null){
            return null;
        }
        
        return new PersonDTO(saveDTOgetModel(s,personDTO));
    }
    
    @Override
    public IPerson saveDTOgetModel(Session s,IPersonDTO personDTO){
           
        if (personDTO == null){
            return null;
        }
        
        IPerson person = getById(s,personDTO.getId()) ;
        //IAddress address = 
        if(person == null){
            person = create();
        }
        
        person.setFirstname(personDTO.getFirstname());
        person.setLastname(personDTO.getLastname());
        person.setUsername(personDTO.getUsername());
        person.setPassword(personDTO.getPassword());
        person.setPhone(personDTO.getPhone());
        person.setRight(personDTO.getRight());
        person.setMail(personDTO.getMail());
        person.setSex(personDTO.getSex());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdate = null;
        try {
            birthdate = new Date(sdf.parse(personDTO.getBirthdate()).getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        person.setBirthdate(birthdate);
        person.setMainAddress(AddressDAO.getInstance().saveDTOgetModel(s,personDTO.getMainAddress()));
        
        s.saveOrUpdate(person);
        
        return person;
            
    }
}
