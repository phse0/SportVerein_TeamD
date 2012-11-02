/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.edit.States;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public interface IPersonEditState extends IController {
    public LinkedList<ISportDTO> loadSports() throws RemoteException;
    public IPersonDTO editPerson(int PersonID, String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country/*, int contributionID*/);
    public void AssignToSport(LinkedList<String> sport, int personID);
}
