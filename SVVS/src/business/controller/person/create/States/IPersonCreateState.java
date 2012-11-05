/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public interface IPersonCreateState extends IController {
    public LinkedList<ICountryDTO> loadCountries() throws RemoteException;
    public LinkedList<ISportDTO> loadSports() throws RemoteException;
    public LinkedList<IContributionDTO> loadContributions() throws RemoteException;
    
    public IPersonDTO CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country, int contributionID) throws RemoteException;
    
    
    public void AssignToSport(LinkedList<String> sport, int personID) throws RemoteException;

    IPersonDTO CreatePersonDTO() throws  RemoteException;

    IPersonDTO SaveDTO(IPersonDTO dto) throws  RemoteException;
}
