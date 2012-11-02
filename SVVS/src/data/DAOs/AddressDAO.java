/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.AddressDTO;
import data.DTOs.CountryDTO;
import data.interfaces.DAOs.IAddressDAO;
import data.interfaces.DAOs.ICountryDAO;
import data.interfaces.DTOs.IAddressDTO;
import data.interfaces.DTOs.ICountryDTO;
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
    public List<IAddress> getByCity(Session s, String city) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE city = :city");
        query.setString(":city", city);
        return query.list();
    }

    @Override
    public IAddressDTO extractDTO(IAddress model) {
        return new AddressDTO(model);
    }

    @Override
    public IAddress getById(Session s, int id) {

        Query query = s.createQuery("FROM " + getTable() + " Where addressID =:id");
        query.setInteger("id", id);
        return (IAddress) query.uniqueResult();
    }

    @Override
    public IAddressDTO saveDTO(Session s, IAddressDTO dto){
        
        if(dto == null){
            return null;
        }
        
        return new AddressDTO(saveDTOgetModel(s,dto));
    }
    
    @Override
    public IAddress saveDTOgetModel(Session s, IAddressDTO dto) {

        if(dto == null){
            return null;
        }
        
        IAddress address = getById(s, dto.getId());

        if (address == null) {
            address = create();
        }
        
        address.setCountry(CountryDAO.getInstance().saveDTOgetModel(s, dto.getCountry()));
        address.setCity(dto.getCity());
        address.setPostcode(dto.getPostcode());
        address.setStreet(dto.getStreet());
        
        s.saveOrUpdate(address);

        return address;
    }
}
