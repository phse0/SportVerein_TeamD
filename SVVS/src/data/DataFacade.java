/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.DAOs.AddressDAO;
import data.DAOs.CountryDAO;
import data.DAOs.PersonDAO;

/**
 *
 * @author Michael
 */
public class DataFacade {
    
    public static AddressDAO getAddressDAO() {
        return AddressDAO.getInstance();
    }
    
    public static CountryDAO getCountryDAO() {
        return CountryDAO.getInstance();
    }
    
    public static PersonDAO getPersonDAO() {
        return PersonDAO.getInstance();
    }
    
}
