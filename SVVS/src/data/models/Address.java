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
    
    @Override
    public int getAddressID() {
        return addressID;
    }

    @Override
    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public ICountry getCountry() {
        return country;
    }

    @Override
    public void setCountry(ICountry country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return street + ", " + postcode + " " + city + ", " + country.getName();
    }
    
    
    
}
