/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IRoleRights;

/**
 *
 * @author uubu
 */
public interface IRoleRightsDTO extends IDTO<IRoleRights> {

    String getName();

    int getRight();

    void setName(String name);

    void setRight(int right);
    
}
