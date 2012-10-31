/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

import data.DAOs.CountryDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class PersonCreateLoadCountryState implements IPersonCreateState {

    PersonCreation _creator;

    public PersonCreateLoadCountryState(PersonCreation creator) {
        _creator = creator;
    }

    @Override
    public LinkedList<ICountry> loadCountries() {
        LinkedList<ICountry> countries = new LinkedList<ICountry>();
        
        for (ICountry iC : CountryDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            countries.add(iC);
        }
        _creator.setState(new PersonCreateLoadSportState(_creator));

        return countries;
    }

    @Override
    public void CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday,
            String street, String postcode, String city, ICountry country) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISport> loadSports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<ISport> sport, IPerson person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
