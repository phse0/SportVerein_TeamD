/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IModel;

/**
 *
 * @author uubu
 */
public interface IDTO<V extends IModel>{
    
   int getId();
   
   void extract(V model);
}
