/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.models.ICountry;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public interface ICountryDAO extends IDAOs<ICountry, ICountryDTO> {
    
    public ICountry getByName(Session s,String name);
    
    public ICountry getByCode(Session s,String code);

    ICountry getById(Session s, int id);

    ICountryDTO saveDTO(Session s, ICountryDTO dto);

    ICountry saveDTOgetModel(Session s, ICountryDTO dto);
    
}
