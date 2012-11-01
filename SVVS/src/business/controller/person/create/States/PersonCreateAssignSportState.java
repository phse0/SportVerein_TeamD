/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.person.create.PersonCreation;
import data.DAOs.RoleDAO;
import data.DTOs.RoleDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.IContribution;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
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
    public LinkedList<ICountry> loadCountries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISport> loadSports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<ISport> sport, IPerson person) {
        for (ISport iSport : sport) {
            
            //assigning values
            Role role = new Role();
            role.setPerson(person);
            role.setSport(iSport);
            
            RoleDAO.getInstance().add(HibernateUtil.getCurrentSession(), role);
        }
    }

    @Override
    public void CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country, int contributionID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<IContribution> loadContributions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
