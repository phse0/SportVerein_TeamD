/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

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

    private static ICountryDAO instance;

    private CountryDAO() {
        super("data.models.Country");
    }

    public static ICountryDAO getInstance() {
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
    public ICountry getByName(Session s,String name) {
 
        Query query = s.createQuery("FROM " + getTable() + " WHERE name = :name");
        query.setString(":name", name);
        return (ICountry) query.list().get(0);
    }

    @Override
    public ICountry getByCode(Session s,String code) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE code = :code");
        query.setString(":code", code);
        return (ICountry) query.list().get(0);
    }
}