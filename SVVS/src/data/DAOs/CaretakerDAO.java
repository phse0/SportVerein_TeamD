/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.CaretakerDTO;
import data.interfaces.DAOs.ICaretakerDAO;
import data.interfaces.DTOs.ICaretakerDTO;
import data.interfaces.models.ICaretaker;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.models.Caretaker;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class CaretakerDAO extends AbstractDAO<ICaretaker, ICaretakerDTO> implements ICaretakerDAO{

    private static ICaretakerDAO instance;
    
    private CaretakerDAO() {
        super("data.models.Address");
    }
    
    public static ICaretakerDAO getInstance(){
        if ( instance == null){
            instance = new CaretakerDAO();
        }
        return instance;
    }
    
    @Override
    public ICaretaker create() {
        return new Caretaker();
    }

    @Override
    public ICaretakerDTO extractDTO(ICaretaker model) {
        return new CaretakerDTO(model);
    }
    
     @Override
    public List<ICaretaker> getByPerson(Session s,IPerson person){
        
        Query query = s.createQuery("FROM "+getTable()+" WHERE person = :person");
        query.setParameter("person", person);
        List<ICaretaker> roles = new LinkedList<>();
        roles = query.list();
        
        if (roles.isEmpty()){
            return null;
        }
        
        return roles;
                
    }
}
