/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.person.PersonController;
import business.controller.person.create.PersonCreation;
import data.DAOs.RoleDAO;
import data.DTOs.PersonDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.DTOs.ISportDTO;
import data.models.Role;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class PersonCreateAssignSportState implements IPersonCreateState{

    PersonCreation _creator;
    public PersonCreateAssignSportState(PersonCreation creator) {
        _creator = creator;
    }

    
    
    @Override
    public LinkedList<ICountryDTO> loadCountries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISportDTO> loadSports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public PersonDTO CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country, int contributionID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<IContributionDTO> loadContributions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<String> sport, int personID) {
        for (String sportname : sport) {
             //assigning values
            Role role = new Role();
            role.setPerson(PersonController.getInstance().loadPersonWithID(personID));
            role.setSport(PersonController.getInstance().loadSport(sportname));
            
            RoleDAO.getInstance().add(HibernateUtil.getCurrentSession(), role);
        }
    }
    
}
