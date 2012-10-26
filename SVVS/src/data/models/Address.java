/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IAddress;
import data.interfaces.models.ICountry;

/**
 *
 * @author uubu
 */
public class Address implements IAddress{
    
    protected int addressID;
    protected String street;
    protected String postcode;
    protected String city;
    protected ICountry country;

    public Address() {
    }
    
    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ICountry getCountry() {
        return country;
    }

    public void setCountry(ICountry country) {
        this.country = country;
    }
    
}
