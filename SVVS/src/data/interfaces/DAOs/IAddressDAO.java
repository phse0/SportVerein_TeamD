/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IAddressDTO;
import data.interfaces.models.IAddress;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public interface IAddressDAO extends IDAOs<IAddress,IAddressDTO> {
    
    public List<IAddress> getByCity(Session s, String city);

    IAddress getById(Session s, int id);

    IAddressDTO saveDTO(Session s, IAddressDTO dto);

    IAddress saveDTOgetModel(Session s, IAddressDTO dto);
    
}
