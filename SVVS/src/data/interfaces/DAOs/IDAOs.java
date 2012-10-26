/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.models.IModel;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface IDAOs<V extends IModel> {
    
    public List<V> getAll();
    
    public void add(V model);
    
    public void remove(V model);
    
    public void update(V model);
    
    public V create();
}
