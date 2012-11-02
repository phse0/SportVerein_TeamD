/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.person.PersonController;
import business.controller.person.create.PersonCreation;
import data.DAOs.SportDAO;
import data.DTOs.SportDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ISport;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class PersonCreateLoadSportState implements IPersonCreateState {

    PersonCreation _creator;

   public PersonCreateLoadSportState(PersonCreation creator) {
        _creator = creator;
    }

    @Override
    public LinkedList<ICountryDTO> loadCountries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISportDTO> loadSports() throws RemoteException {
        /*LinkedList<ISportDTO> sports = new LinkedList<ISportDTO>();

        for (ISport iS : SportDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            SportDTO sdto = new SportDTO(iS);
            sports.add(sdto);
        }
        _creator.setState(new PersonCreateLoadContributionState(_creator));


        return sports;*/
        _creator.setState(new PersonCreateLoadContributionState(_creator));
        return PersonController.getInstance().loadSports();
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
