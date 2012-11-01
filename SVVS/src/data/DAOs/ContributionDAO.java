/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.ContributionDTO;
import data.interfaces.DAOs.IContributionDAO;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.models.IContribution;
import data.models.Contribution;

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
    
}
