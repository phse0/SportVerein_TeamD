/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.edit;

import business.controller.person.edit.States.IPersonEditState;
import business.controller.person.edit.States.PersonEditSearchPersonState;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.LinkedList;

/**
 * First loadsports
 * Second EditPerson
 * Third AssignToSport
 * @author phil
 */
public class PersonEdit  extends UnicastRemoteObject  implements IPersonEdit {
    IPersonEditState _state;

    public IPersonEditState getState() {
        return _state;
    }

    public void setState(IPersonEditState _state) {
        this._state = _state;
    }

    public PersonEdit() throws RemoteException {
        super();
        setState(new PersonEditSearchPersonState(this));
    }

    @Override
    public LinkedList<ISportDTO> loadSports() {
        return _state.loadSports();
    }

    @Override
    public IPersonDTO editPerson(int PersonID, String firstname, String lastname, String sex, String phone, String mail, String username, String password, Date birthday, int right, String street, String postcode, String city, String country) {
        return _state.editPerson(PersonID, firstname, lastname, sex, phone, mail, username, password, birthday, right, street, postcode, city, country);
    }

    @Override
    public void AssignToSport(LinkedList<String> sport, int personID) {
        _state.AssignToSport(sport, personID);
    }

   
}
