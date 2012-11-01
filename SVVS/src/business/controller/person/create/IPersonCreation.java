/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import java.rmi.Remote;
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
public interface IPersonCreation extends Remote, IController {
    public LinkedList<ICountryDTO> loadCountries();
    public LinkedList<ISportDTO> loadSports();
    public LinkedList<IContributionDTO> loadContributions();
    
    public IPersonDTO CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country, int contributionID);
    
    public void AssignToSport(LinkedList<String> sport, int personID);
}
