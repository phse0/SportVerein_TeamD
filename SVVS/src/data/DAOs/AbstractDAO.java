/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IDAOs;
import data.interfaces.DTOs.IDTO;
import data.interfaces.models.IModel;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public abstract class AbstractDAO<V extends IModel, X extends IDTO> implements IDAOs<V,X> {

    private String table;

    public AbstractDAO(String table) {
        this.table = table;
    }

    protected String getTable() {
        return table;
    }

    @Override
    public List<X> getAllDTO(Session s){
        List<X> dto = new LinkedList<>();
        
        for(V model :getAll(s)){
            dto.add(extractDTO(model));
        }
        return dto;
    }
            
    @Override
    public List<V> getAll(Session s) {
        Query query = s.createQuery("FROM " + getTable() + "");
        return query.list();
    }

    @Override
    public void add(Session s,V model) {
        s.save(model);
    }

    @Override
    public void remove(Session s,V model) {
        s.delete(model);
    }

    @Override
    public void update(Session s,V model) {
        s.update(model);
    }
    
    @Override
    public abstract V create();
    
    //public abstract X createDTO(); 
}
