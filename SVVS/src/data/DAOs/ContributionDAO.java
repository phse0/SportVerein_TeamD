/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IContributionDAO;
import data.interfaces.models.IContribution;
import data.models.Contribution;

/**
 *
 * @author uubu
 */
public class ContributionDAO extends AbstractDAO<IContribution> implements IContributionDAO{

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
    
}
