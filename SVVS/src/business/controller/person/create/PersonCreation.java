/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

import business.controller.person.create.States.IPersonCreateState;
import business.controller.person.create.States.PersonCreateLoadCountryState;
import data.interfaces.models.IContribution;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.LinkedList;

/**
 * First loadCountries
 * Second loadSports
 * Third LoadContributions
 * Fourth CreatePerson
 * Fifth AssignToSport
 *
 * @author phil
 */
public class PersonCreation extends UnicastRemoteObject implements IPersonCreation {

    IPersonCreateState _state;

    public IPersonCreateState getState() {
        return _state;
    }

    public void setState(IPersonCreateState _state) {
        this._state = _state;
    }

    public PersonCreation() throws RemoteException {
        super();
        setState(new PersonCreateLoadCountryState(this));
    }

    @Override
    public LinkedList<ICountry> loadCountries() {
        return _state.loadCountries();
    }

    @Override
    public LinkedList<ISport> loadSports() {
        return _state.loadSports();
    }

    @Override
    public LinkedList<IContribution> loadContributions() {
        return _state.loadContributions();
    }

    @Override
    public void CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country, int contributionID) {
        _state.CreatePerson(firstname, lastname, sex, phone, mail,
                username, password, birthday, right,
                street, postcode, city, country, contributionID);
    }

    @Override
    public void AssignToSport(LinkedList<ISport> sport, IPerson person) {
        _state.AssignToSport(sport, person);;
    }
}
