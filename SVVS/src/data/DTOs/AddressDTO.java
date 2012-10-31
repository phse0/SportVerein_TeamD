/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IAddressDTO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.models.IAddress;

/**
 *
 * @author uubu
 */
public class AddressDTO extends AbstractDTO<IAddress> implements IAddressDTO{

    protected String street;
    protected String postcode;
    protected String city;
    protected ICountryDTO country;
    
    public AddressDTO(IAddress model){
        extract(model);
    }
    
    @Override
    final void extract(IAddress model) {
        this.id = model.getAddressID();
        this.street = model.getStreet();
        this.city = model.getCity();
        this.country = new CountryDTO(model.getCountry());
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String getPostcode() {
        return this.postcode;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCity() {
       return this.city;
    }

    @Override
    public void setCountry(ICountryDTO country) {
        this.country = country;
    }

    @Override
    public ICountryDTO getCountry() {
        return this.country;
    }
    
    @Override
    public String toString() {
        return street + ", " + postcode + " " + city + ", " + country.getName();
    }
    
}
