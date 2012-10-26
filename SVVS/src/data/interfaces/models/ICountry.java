/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface ICountry extends IModel {

    String getCode();

    int getCountryID();

    String getName();

    void setCode(String code);

    void setCountryID(int countryID);

    void setName(String name);
    
}
