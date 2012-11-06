/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import java.util.List;

/**
 *
 * @author uubu
 */
public interface IAddress extends IModel {

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

    void addPerson(IPerson persons);

    List<IPerson> getPersons();

    void removePerson(IPerson persons);

    void setPersons(List<IPerson> persons);
    
}
