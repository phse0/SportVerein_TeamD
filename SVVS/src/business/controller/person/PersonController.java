/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person;

import business.controller.person.create.States.PersonCreateLoadSportState;
import data.DAOs.CountryDAO;
import data.DAOs.PersonDAO;
import data.DAOs.SportDAO;
import data.DTOs.CountryDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class PersonController {

    private static PersonController instance;

    private PersonController() {
    }

    public static PersonController getInstance() {
        if (instance == null) {
            return (instance = new PersonController());
        }
        return instance;
    }

    public LinkedList<ICountryDTO> loadCountries() {
        LinkedList<ICountryDTO> countries = new LinkedList<ICountryDTO>();

        for (ICountry iC : CountryDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            CountryDTO cdto = new CountryDTO(iC);
            countries.add(cdto);
        }
        return countries;
    }

    public ISport loadSport(String name) {
        return SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), name);
    }

    public IPerson loadPersonWithID(int personID) {
     List<IPerson> persons =    PersonDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        for (IPerson ip : persons) {
            if (ip.getPersonID() == personID) {
                return ip;
            }
        }
        return null;
    }
}
