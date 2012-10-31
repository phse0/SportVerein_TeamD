/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IDTO;
import data.interfaces.models.IModel;

/**
 *
 * @author uubu
 */
public abstract class AbstractDTO<V extends IModel> implements IDTO<V> {
    
    protected int id;
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public abstract void extract(V model);
    
}
