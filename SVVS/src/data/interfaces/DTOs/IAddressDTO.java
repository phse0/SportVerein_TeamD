/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IAddress;

/**
 *
 * @author uubu
 */
public interface IAddressDTO extends IDTO<IAddress>{

    void setStreet(String street);
    String getStreet();
    
    void setPostcode(String postcode);
    String getPostcode();
    
    void setCity(String city);
    String getCity();
    
    void setCountry(ICountryDTO country);
    ICountryDTO getCountry();
    
}
