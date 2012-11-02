/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.ContributionDTO;
import data.interfaces.DAOs.IContributionDAO;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.models.IContribution;
import data.interfaces.models.IPerson;
import data.models.Contribution;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class ContributionDAO extends AbstractDAO<IContribution, IContributionDTO> implements IContributionDAO{

    private static IContributionDAO instance;
    
    private ContributionDAO() {
        super("data.models.Contribution");
    }
    
    public static IContributionDAO getInstance(){
        if (instance == null){
            instance = new ContributionDAO();
        }
        return instance;
    }
    
    @Override
    public IContribution create() {
        return new Contribution();
    }

    @Override
    public IContributionDTO extractDTO(IContribution model) {
        return new ContributionDTO(model);
    }
    
    public List<IContribution> getByPerson(Session s,IPerson model) {
        
        Query query = s.createQuery("FROM " + getTable() + " WHERE person = :model");
        query.setParameter("model", model);
        return query.list();    
    }
    

    @Override
    public IContribution getById(Session s, int id) {

        Query query = s.createQuery("FROM" + getTable() + "Where contributionID =:id");
        query.setInteger("id", id);
        return (IContribution) query.uniqueResult();
    }

    @Override
    public IContribution saveDTOgetModel(Session s, IContributionDTO dto) {

        if (dto == null) {
            return null;
        }

        IContribution contribution = getById(s, dto.getId());

        if (contribution == null) {
            contribution = create();
        }
        contribution.setName(dto.getName());
        contribution.setValue(BigDecimal.valueOf(dto.getValue()));

        s.saveOrUpdate(contribution);

        return contribution;
    }


    @Override
    public IContributionDTO saveDTO(Session s, IContributionDTO dto) {

        return new ContributionDTO(saveDTOgetModel(s, dto));
    }
    
}
