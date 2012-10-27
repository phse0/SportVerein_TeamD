/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.DAOs.AddressDAO;
import data.DAOs.CountryDAO;
import data.DAOs.PersonDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.IAddress;
import data.interfaces.models.ICountry;
import data.interfaces.models.IPerson;
import java.util.List;
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

        CountryDAO countryDAO = CountryDAO.getInstance();
        List<ICountry> countryList = countryDAO.getAll(s);

        for (ICountry country : countryList) {
            System.out.println(country.getName() + ", " + country.getCode());
        }

        System.out.println("######## ADDRESS ########");
        AddressDAO addressDAO = AddressDAO.getInstance();
        List<IAddress> addressList = addressDAO.getAll(s);

        for (IAddress address : addressList) {
            System.out.println(address.getStreet() + ", " + address.getPostcode() + ", "
                    + address.getCity() + ", " + address.getCountry().getName());
        }

        System.out.println("######## PERSON ########");
        PersonDAO personDAO = PersonDAO.getInstance();
        List<IPerson> personList = personDAO.getLikeName(s,"ste");

        for (IPerson person : personList) {
            System.out.println(person.getLastname() + " " + person.getFirstname()
                    + ", " + person.getSex() + ", " + person.getBirthdate());
        }
        
        
        tx.commit();
        if (s.isOpen()) {
            s.close();
        }
    }
}
