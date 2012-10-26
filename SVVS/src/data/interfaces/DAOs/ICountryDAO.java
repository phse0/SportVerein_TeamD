/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.models.ICountry;

/**
 *
 * @author Michael
 */
public interface ICountryDAO extends IDAOs<ICountry> {
    
    public ICountry getByName(String name);
    
    public ICountry getByCode(String code);
    
}
