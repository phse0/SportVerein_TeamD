/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.AdministratorDTO;
import data.interfaces.DAOs.IAdministratorDAO;
import data.interfaces.DTOs.IAdministratorDTO;
import data.interfaces.models.IAdministrator;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.models.Administrator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class AdministratorDAO extends AbstractDAO<IAdministrator, IAdministratorDTO> implements IAdministratorDAO {

    private static IAdministratorDAO instance;
    
    private AdministratorDAO(){
        super("data.models.Administrator");
    }
    
    public static IAdministratorDAO getInstance(){
        if ( instance == null){
            instance = new AdministratorDAO();
        }
        return instance;
    }
    
    @Override
    public IAdministrator create() {
        return new Administrator();
    }

    @Override
    public IAdministratorDTO extractDTO(IAdministrator model) {
        return new AdministratorDTO(model);
    }
    
     @Override
    public List<IAdministrator> getByPerson(Session s,IPerson person){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person");
        query.setParameter("person", person);
        List<IAdministrator> roles = new LinkedList<>();
        roles = query.list();
        
        if (roles.isEmpty()){
            return null;
        }
        
        return roles;
                
    }
}
