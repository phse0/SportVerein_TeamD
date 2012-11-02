/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.edit.States;

import business.controller.person.PersonController;
import business.controller.person.edit.PersonEdit;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class PersonEditSearchPersonState implements IPersonEditState{

    PersonEdit _editor;

    public PersonEditSearchPersonState(PersonEdit editor) {
        _editor = editor;
    }

    @Override
    public LinkedList<ISportDTO> loadSports() throws RemoteException {
        _editor.setState(new PersonEditState(_editor));
        return PersonController.getInstance().loadSports();
    }

    @Override
    public IPersonDTO editPerson(int PersonID, String firstname, String lastname,
    String sex, String phone, String mail, String username, String password, Date birthday,
    int right, String street, String postcode, String city, String country/*, int contributionID*/) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<String> sport, int personID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
