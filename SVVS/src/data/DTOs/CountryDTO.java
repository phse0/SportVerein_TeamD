/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.models.ICountry;

/**
 *
 * @author uubu
 */
public class CountryDTO implements ICountryDTO{

    private int id;
    private String name;
    private String code;
    
    public CountryDTO(){ 
    }
    
    public CountryDTO(ICountry country){
        this.id = country.getCountryID();
        this.name = country.getName();
        this.code = country.getCode();
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
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int getId() {
        return id;
    }
    
}
