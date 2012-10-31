/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

import data.DAOs.AddressDAO;
import data.DAOs.PersonDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import java.util.LinkedList;
import java.sql.Date;
import org.hibernate.Hibernate;

/**
 *
 * @author phil
 */
public class PersonCreateState implements IPersonCreateState {

    PersonCreation _creator;

    public PersonCreateState(PersonCreation creator) {
        _creator = creator;
    }

    @Override
    public LinkedList<ICountry> loadCountries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CreatePerson(String firstname, String lastname,
    String sex, String phone, String mail,
    String username, String password, Date birthday,
    String street, String postcode, String city, ICountry country) {
        AddressDTO address = new AddressDTO();
        //fill getter and setter
        AddressDAO.getInstance().saveDTO(address, HibernateUtil.getCurrentSession());
        PersonDTO person = new PersonDTO();
        //fill getter and setter
        PersonDAO.getInstance().saveDTO(person, HibernateUtil.getCurrentSession());
        _creator.setState(new PersonCreateAssignSportState(_creator));
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
