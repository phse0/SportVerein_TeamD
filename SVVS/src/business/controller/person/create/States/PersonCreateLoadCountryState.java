/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.person.PersonController;
import business.controller.person.create.PersonCreation;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
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
    public LinkedList<ICountryDTO> loadCountries() {
      /* LinkedList<ICountry> countries = new LinkedList<ICountry>();
        
        for (ICountry iC : CountryDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            countries.add(iC);
        }
        _creator.setState(new PersonCreateLoadSportState(_creator));

        return countries;*/
         _creator.setState(new PersonCreateLoadSportState(_creator));
        return PersonController.getInstance().loadCountries();
    }


    @Override
    public LinkedList<ISportDTO> loadSports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



    @Override
    public LinkedList<IContributionDTO> loadContributions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IPersonDTO CreatePerson(String firstname, String lastname, String sex, String phone, String mail, String username, String password, Date birthday, int right, String street, String postcode, String city, String country, int contributionID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<String> sport, int personID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
