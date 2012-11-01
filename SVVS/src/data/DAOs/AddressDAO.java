/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.AddressDTO;
import data.interfaces.DAOs.IAddressDAO;
import data.interfaces.DTOs.IAddressDTO;
import data.interfaces.models.IAddress;
import data.models.Address;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public class AddressDAO extends AbstractDAO<IAddress, IAddressDTO> implements IAddressDAO {

    private static IAddressDAO instance;

    private AddressDAO() {
        super("data.models.Address");
    }

    public static IAddressDAO getInstance() {
        if (instance == null) {
            instance = new AddressDAO();
        }
        return instance;
    }

    @Override
    public IAddress create() {
        return new Address();
    }

    @Override
    public List<IAddress> getByCity(Session s,String city) {
       
        Query query = s.createQuery("FROM " + getTable() + " WHERE city = :city");
        query.setString(":city", city);
        return query.list();
    }

    @Override
    public IAddressDTO extractDTO(IAddress model) {
        return new AddressDTO(model);
    }


}
