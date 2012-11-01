/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IDTO;
import data.interfaces.models.IModel;
import java.util.List;
import org.hibernate.Session;

/**
 * * @author Michael
 */
public interface IDAOs<V extends IModel, X extends IDTO> {
    
    public List<V> getAll(Session s);
    
    public List<X> getAllDTO(Session s);
    
    public X extractDTO(V model);
    
   // public V extractModel(X dto);
    
    public void add(Session s, V model);
    
    public void remove(Session s, V model);
    
    public void update(Session s, V model);
    
    public V create();
}
