/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.ICountry;

/**
 *
 * @author uubu
 */
public class Country implements ICountry{
   
    protected int countryID;
    protected String name;
    protected String code;

    public Country() {
    }
    
    @Override
    public int getCountryID() {
        return countryID;
    }

    @Override
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }
      
    
    
}
