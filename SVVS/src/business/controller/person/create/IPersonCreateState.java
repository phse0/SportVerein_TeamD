/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

import business.controller.RMI.IController;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISport;
import java.util.LinkedList;
import java.sql.Date;

/**
 *
 * @author phil
 */
public interface IPersonCreateState extends IController {
    public LinkedList<ICountry> loadCountries();
    
    public void CreatePerson(String firstname, String lastname,
    String sex, String phone, String mail,
    String username, String password, Date birthday,
    String street, String postcode, String city, ICountry country);
    
    public LinkedList<ISport> loadSports();
    public void AssignToSport(LinkedList<ISport> sport, IPerson person);
}
