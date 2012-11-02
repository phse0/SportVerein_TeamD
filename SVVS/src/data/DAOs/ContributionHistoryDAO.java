/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.ContributionHistoryDTO;
import data.interfaces.DAOs.IContributionHistoryDAO;
import data.interfaces.DTOs.IContributionHistoryDTO;
import data.interfaces.models.IContribution;
import data.interfaces.models.IContributionHistory;
import data.models.ContributionHistory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class ContributionHistoryDAO extends AbstractDAO<IContributionHistory, IContributionHistoryDTO> implements IContributionHistoryDAO{

    private static IContributionHistoryDAO instance;
    
    private ContributionHistoryDAO() {
        super("data.models.ContributionHistory");
    }
    
    public static IContributionHistoryDAO getInstance(){
        if (instance == null){
            instance = new ContributionHistoryDAO();
        }
        return instance;
    }
    
    @Override
    public IContributionHistory create() {
        return new ContributionHistory();
    }

    @Override
    public IContributionHistoryDTO extractDTO(IContributionHistory model) {
        return new ContributionHistoryDTO(model);
    }
    
}