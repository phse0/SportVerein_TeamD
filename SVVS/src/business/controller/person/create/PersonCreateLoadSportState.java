/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

import data.DAOs.SportDAO;
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
public class PersonCreateLoadSportState implements IPersonCreateState {

    PersonCreation _creator;

    PersonCreateLoadSportState(PersonCreation creator) {
        _creator = creator;
    }

    @Override
    public LinkedList<ICountry> loadCountries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISport> loadSports() {
        LinkedList<ISport> sports = new LinkedList<ISport>();
        
        for (ISport iS : SportDAO.getInstance().getAll(HibernateUtil.getCurrentSession())){
        sports.add(iS);
        }
         _creator.setState(new PersonCreateState(_creator));
        
        return new LinkedList<ISport>();
    }

    @Override
    public void AssignToSport(LinkedList<ISport> sport, IPerson person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CreatePerson(String firstname, String lastname, String sex,
    String phone, String mail, String username, String password,
    Date birthday, String street, String postcode, String city, ICountry country) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
