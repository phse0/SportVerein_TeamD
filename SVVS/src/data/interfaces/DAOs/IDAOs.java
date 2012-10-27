/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.models.IModel;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public interface IDAOs<V extends IModel> {
    
    public List<V> getAll(Session s);
    
    public void add(Session s, V model);
    
    public void remove(Session s, V model);
    
    public void update(Session s, V model);
    
    public V create();
}
