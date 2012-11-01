/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.person.create.PersonCreation;
import data.DAOs.AddressDAO;
import data.DAOs.ContributionDAO;
import data.DAOs.CountryDAO;
import data.DAOs.PersonDAO;
import data.DTOs.AddressDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.IContribution;
import data.interfaces.models.IContributionHistory;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import data.models.Address;
import data.models.ContributionHistory;
import data.models.Person;
import java.sql.Date;
import java.util.LinkedList;
import org.joda.time.DateTime;

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
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country, int contributionID) {
        Address address = new Address();
        //assigning values
        address.setStreet(street);
        address.setCity(city);
        address.setPostcode(postcode);

        ICountry c = CountryDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), country);
        address.setCountry(c);

        //fill getter and setter
        AddressDAO.getInstance().add(HibernateUtil.getCurrentSession(), address);

        Person person = new Person();
        //fill getter and setter
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setSex(sex);
        person.setPhone(phone);
        person.setMail(mail);
        person.setUsername(username);
        person.setPassword(password);
        person.setMainAddress(address);
        person.setBirthdate(birthday);
        person.setRight(right);

        ContributionHistory ch = new ContributionHistory(person, getContributionByID(contributionID),
                DateTime.now().getYear(), DateTime.now().getMonthOfYear(), "0");
        
        LinkedList<IContributionHistory> chh = new LinkedList<IContributionHistory>();
        chh.add(ch);
        person.setContributionHistory(chh);

        PersonDAO.getInstance().add(HibernateUtil.getCurrentSession(), person);

        _creator.setState(new PersonCreateAssignSportState(_creator));
    }

    /**
     * Return a Contribution searched with the id
     *
     * @param contributionID
     * @return
     */
    private IContribution getContributionByID(int contributionID) {
        for (IContribution ic : ContributionDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (ic.getContributionID() == contributionID) {
                return ic;
            }
        }
        return null;
    }

    @Override
    public LinkedList<ISport> loadSports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<ISport> sport, IPerson person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<IContribution> loadContributions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}