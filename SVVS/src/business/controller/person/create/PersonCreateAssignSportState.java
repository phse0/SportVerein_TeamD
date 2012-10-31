/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

import data.DAOs.RoleDAO;
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
            RoleDTO role = new RoleDTO();
            //assign things here
            RoleDAO.getInstance().saveDTO(role, HibernateUtil.getCurrentSession());
        }
    }

    @Override
    public void CreatePerson(String firstname, String lastname, String sex, String phone, String mail, String username, String password, Date birthday, String street, String postcode, String city, ICountry country) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
