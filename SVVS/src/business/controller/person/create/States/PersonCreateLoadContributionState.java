/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.person.create.PersonCreation;
import data.DAOs.ContributionDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.IContribution;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class PersonCreateLoadContributionState implements IPersonCreateState {

    PersonCreation _creator;

    public PersonCreateLoadContributionState(PersonCreation creator) {
        _creator = creator;
    }

    @Override
    public LinkedList<ICountry> loadCountries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISport> loadSports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<IContribution> loadContributions() {
        LinkedList<IContribution> contributions = new LinkedList<IContribution>();
        
        for (IContribution iC : ContributionDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            contributions.add(iC);
        }
        
        _creator.setState(new PersonCreateState(_creator));
        return contributions;
    }

    @Override
    public void CreatePerson(String firstname, String lastname, String sex,
    String phone, String mail, String username, String password,
    Date birthday, int right, String street, String postcode, String city, String country, int contributionID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<ISport> sport, IPerson person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
