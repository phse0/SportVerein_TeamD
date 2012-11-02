/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DAOs;

import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.models.IContribution;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public interface IContributionDAO extends IDAOs<IContribution, IContributionDTO>{

    IContribution getById(Session s, int id);

    IContributionDTO saveDTO(Session s, IContributionDTO dto);

    IContribution saveDTOgetModel(Session s, IContributionDTO dto);
    
}
