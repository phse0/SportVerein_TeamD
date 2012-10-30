/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.DAOs.AddressDAO;
import data.DAOs.CountryDAO;
import data.DAOs.PersonDAO;
import data.DAOs.TrainingTeamDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.IAddressDAO;
import data.interfaces.DAOs.ICountryDAO;
import data.interfaces.DAOs.IPersonDAO;
import data.interfaces.DAOs.ITrainingTeamDAO;
import data.interfaces.models.IAddress;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITrainingTeam;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */
public class test {

    public static void main(String args[]) {

        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();

        System.out.println("######## COUNTRY ########");

        ICountryDAO countryDAO = CountryDAO.getInstance();
        List<ICountry> countryList = countryDAO.getAll(s);

        for (ICountry country : countryList) {
            System.out.println(country.getName() + ", " + country.getCode());
        }

        System.out.println("######## ADDRESS ########");
        IAddressDAO addressDAO = AddressDAO.getInstance();
        List<IAddress> addressList = addressDAO.getAll(s);

        for (IAddress address : addressList) {
            System.out.println(address.getStreet() + ", " + address.getPostcode() + ", "
                    + address.getCity() + ", " + address.getCountry().getName());
        }

        System.out.println("######## PERSON ########");

        IPersonDAO personDAO = PersonDAO.getInstance();
        List<IPerson> personList = personDAO.getLikeName(s, "ste");

        for (IPerson person : personList) {
            System.out.println(person.getLastname() + " " + person.getFirstname()
                    + ", " + person.getSex() + ", " + person.getBirthdate());
        }

        System.out.println("######## TRAINING TEAM ########");

        ITrainingTeamDAO trainingTeamDAO = TrainingTeamDAO.getInstance();
        ITrainingTeam trainingTeam = trainingTeamDAO.getByName(s, "tiger");

        if (trainingTeam != null) {
            
            System.out.println(trainingTeam.getName());
            System.out.println(trainingTeam.getSportsmen().size());
            
            Query query = s.createQuery("FROM data.models.Role WHERE roleID = 0");
            ISportsman sm = (ISportsman)query.uniqueResult();
            System.out.println(sm.getPerson());
            
            for (ISportsmanTrainingTeam i : trainingTeam.getSportsmen()) {
                //System.out.print(i.getSportsman()); 
                //System.out.print(i.getSportsman().getPerson().getFirstname() + " " + 
                  //      i.getSportsman().getPerson().getLastname());
                //System.out.print(", " + i.getPosition());
            }
        }

        tx.commit();
        if (s.isOpen()) {
            s.close();
        }


    }
}
