/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.ICountryDAO;
import data.interfaces.models.ICountry;
import data.models.Country;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public class CountryDAO extends AbstractDAO<ICountry> implements ICountryDAO {

    private static CountryDAO instance;

    private CountryDAO() {
        super("data.models.Country");
    }

    public static CountryDAO getInstance() {
        if (instance == null) {
            instance = new CountryDAO();
        }
        return instance;
    }

    @Override
    public ICountry create() {
        return new Country();
    }

    @Override
    public ICountry getByName(String name) {
        Session s = HibernateUtil.getCurrentSession();

        Query query = s.createQuery("FROM " + getTable() + " WHERE name = :name");
        query.setString(":name", name);
        return (ICountry) query.list().get(0);
    }

    @Override
    public ICountry getByCode(String code) {
        Session s = HibernateUtil.getCurrentSession();

        Query query = s.createQuery("FROM " + getTable() + " WHERE code = :code");
        query.setString(":code", code);
        return (ICountry) query.list().get(0);
    }
}
