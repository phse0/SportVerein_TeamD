/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.CountryDTO;
import data.interfaces.DAOs.ICountryDAO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.models.ICountry;
import data.models.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */
public class CountryDAO extends AbstractDAO<ICountry, ICountryDTO> implements ICountryDAO {

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
    public ICountryDTO extractDTO(ICountry country) {
        return new CountryDTO(country);
    }

    @Override
    public ICountry create() {
        return new Country();
    }

    @Override
    public ICountry getByName(Session s, String name) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE name = '" + name + "'");
        return (ICountry) query.list().get(0);
    }

    @Override
    public ICountry getByCode(Session s, String code) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE code = :code");
        query.setString(":code", code);
        return (ICountry) query.list().get(0);
    }

    @Override
    public ICountry getById(Session s, int id) {

        Query query = s.createQuery("FROM" + getTable() + "Where countryID =:id");
        query.setInteger("id", id);
        return (ICountry) query.uniqueResult();
    }

    @Override
    public ICountry saveDTOgetModel(Session s, ICountryDTO dto) {

        if (dto == null) {
            return null;
        }

        ICountry country = getById(s, dto.getId());

        if (country == null) {
            country = create();
        }
        country.setName(dto.getName());
        country.setCode(dto.getCode());

        s.saveOrUpdate(country);

        return country;
    }

    @Override
    public ICountryDTO saveDTO(Session s, ICountryDTO dto) {

        return new CountryDTO(saveDTOgetModel(s, dto));
    }
}
