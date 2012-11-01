/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person;

import business.controller.person.create.States.PersonCreateLoadSportState;
import data.DAOs.CountryDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.ICountry;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class PersonController {
    
    
    private LinkedList<ICountry> loadCountries() {
        LinkedList<ICountry> countries = new LinkedList<ICountry>();
        
        for (ICountry iC : CountryDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            countries.add(iC);
        }
        return countries;
    }
}
