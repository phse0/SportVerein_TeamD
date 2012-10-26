/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface IAddress {

    int getAddressID();

    String getCity();

    ICountry getCountry();

    String getPostcode();

    String getStreet();

    void setAddressID(int addressID);

    void setCity(String city);

    void setCountry(ICountry country);

    void setPostcode(String postcode);

    void setStreet(String street);
    
}
