/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IContributionDAO;
import data.interfaces.models.IContribution;

/**
 *
 * @author uubu
 */
public class ContributionDAO extends AbstractDAO<IContribution> implements IContributionDAO{

    private static ContributionDAO instance;
    
    private ContributionDAO() {
        super("data.models.Contribution");
    }
    
    private static ContributionDAO getInstance(){
        if (instance == null){
            instance = new ContributionDAO();
        }
        return instance;
    }
    
    @Override
    public IContribution create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
