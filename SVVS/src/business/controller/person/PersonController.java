/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person;

import business.controller.RMI.IController;
import data.DAOs.CountryDAO;
import data.DAOs.PersonDAO;
import data.DAOs.RoleDAO;
import data.DAOs.SportDAO;
import data.DTOs.CountryDTO;
import data.DTOs.PersonDTO;
import data.DTOs.SportDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.IContributionHistory;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.ISport;
import java.rmi.Remote;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class PersonController implements IPersonController {

    private static PersonController instance;

    private PersonController() {
    }

    public static PersonController getInstance() {
        if (instance == null) {
            return (instance = new PersonController());
        }
        return instance;
    }

    @Override
    public LinkedList<ICountryDTO> loadCountries() {
        LinkedList<ICountryDTO> countries = new LinkedList<ICountryDTO>();

        for (ICountry iC : CountryDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            CountryDTO cdto = new CountryDTO(iC);
            countries.add(cdto);
        }
        return countries;
    }

    public ISport loadSport(String name) {
        return SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), name);
    }

    @Override
    public LinkedList<ISportDTO> loadSports() {
        LinkedList<ISportDTO> sports = new LinkedList<ISportDTO>();

        for (ISport iS : SportDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            SportDTO sdto = new SportDTO(iS);
            sports.add(sdto);
        }

        return sports;
    }

    public IPersonDTO loadPersonWithID(int personID) {
        List<IPerson> persons = PersonDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        for (IPerson ip : persons) {
            if (ip.getPersonID() == personID) {
                return new PersonDTO(ip);
            }
        }
        return null;
    }

    public List<IPersonDTO> loadPersonsWithContribution(String ContributionName) {
        List<IPersonDTO> persons = new LinkedList<IPersonDTO>();
        for (IPerson ip : loadPersonsModel()) {
            for (IContributionHistory ch : ip.getContributionHistory()) {
                if (ch.getContribution().getName().equals(ContributionName)) {
                    persons.add(new PersonDTO(ip));
                    //TODO Check if break or continue
                    break;
                }
            }
        }
        return persons;
    }

    public List<IPersonDTO> loadPersonsWithSports(List<String> SportNames) {
        List<IPersonDTO> persons = new LinkedList<IPersonDTO>();
        for (IRole ir : RoleDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            for (String name : SportNames) {
                if (ir.getSport().getName().equals(name)) {
                    for (IPersonDTO iPersonDTO : persons) {
                        //Wenn Person mit gleichen vor und nachnamen nicht schon vorhanden ist hinzufügen
                        if (!((iPersonDTO.getFirstname().equals(ir.getPerson().getFirstname()))
                                && (iPersonDTO.getLastname().equals(ir.getPerson().getLastname())))) {
                            persons.add(iPersonDTO);
                        }
                    }
                }
            }
        }
        return persons;
    }

    private List<IPerson> loadPersonsModel() {
        return PersonDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
    }
    
    @Override
    public List<IPersonDTO> loadPersons() {
        List<IPersonDTO> personsDTO = new LinkedList<>();
        
        for(IPerson ip : loadPersonsModel()) {
            personsDTO.add(new PersonDTO(ip));
        }
        
        return personsDTO;
    }

    public IPerson loadPersonWithIDNonDTO(int personID) {
        List<IPerson> persons = PersonDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        for (IPerson ip : persons) {
            if (ip.getPersonID() == personID) {
                return ip;
            }
        }
        return null;
    }
}
