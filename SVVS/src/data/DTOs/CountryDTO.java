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
public class CountryDTO extends AbstractDTO<ICountry> implements ICountryDTO{

    private String name;
    private String code;

    public CountryDTO(){
        
    }
    
    public CountryDTO(ICountry model){
        extract(model);
    }
    
    
    @Override
    public final void extract(ICountry model){
        this.id = model.getCountryID();
        this.name = model.getName();
        this.code = model.getCode();
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

    @Override
    public String toString() {
        return getName();
    }

}
