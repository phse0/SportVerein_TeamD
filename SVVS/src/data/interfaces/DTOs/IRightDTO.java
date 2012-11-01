/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IRight;

/**
 *
 * @author uubu
 */
public interface IRightDTO extends IDTO<IRight> {

    String getName();

    long getValue();

    void setName(String name);

    void setValue(long value);
    
}
