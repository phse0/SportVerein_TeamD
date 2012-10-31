/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

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
 * Third CreatePerson
 * Fourth AssignToSport
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
    public void CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday,
            String street, String postcode, String city, ICountry country) {
        _state.CreatePerson(firstname, lastname, sex, phone, mail,
                username, password, birthday, street, postcode, city, country);
    }

    @Override
    public LinkedList<ISport> loadSports() {
        return _state.loadSports();
    }

    @Override
    public void AssignToSport(LinkedList<ISport> sport, IPerson person) {
        _state.AssignToSport(sport, person);;
    }
}
