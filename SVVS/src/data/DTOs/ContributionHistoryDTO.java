/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.IContributionHistoryDTO;
import data.interfaces.models.IContributionHistory;

/**
 *
 * @author uubu
 */
public class ContributionHistoryDTO  extends AbstractDTO<IContributionHistory> implements IContributionHistoryDTO {

    private IContributionDTO contribution;
    private int year;
    private int month;
    private String status;
    
     public ContributionHistoryDTO(IContributionHistory model) {
        
        extract(model);
    }
    
    @Override
    public void extract(IContributionHistory model) {
        this.id = model.getContributionHistoryID();
        this.month = model.getMonth();
        this.year = model.getYear();
        this.contribution = new ContributionDTO(model.getContribution());
                
    }

    @Override
    public IContributionDTO getContribution() {
        return contribution;
    }

    @Override
    public void setContribution(IContributionDTO contribution) {
        this.contribution = contribution;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
