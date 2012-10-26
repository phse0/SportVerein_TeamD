/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IContribution;
import data.interfaces.models.IContributionHistory;
import data.interfaces.models.IPerson;

/**
 *
 * @author Michael
 */
public class ContributionHistory implements IContributionHistory {
    
    private int contributionHistoryID;
    private IPerson person;
    private IContribution contribution;
    private int year;
    private int month;
    private String status;

    public ContributionHistory() {
    }

    public ContributionHistory(IPerson person, IContribution contribution, int year, int month, String status) {
        this.person = person;
        this.contribution = contribution;
        this.year = year;
        this.month = month;
        this.status = status;
    }
    
    @Override
    public IPerson getPerson() {
        return person;
    }

    @Override
    public void setPerson(IPerson person) {
        this.person = person;
    }

    @Override
    public IContribution getContribution() {
        return contribution;
    }

    @Override
    public void setContribution(IContribution contribution) {
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

    public int getContributionHistoryID() {
        return contributionHistoryID;
    }

    public void setContributionHistoryID(int contributionHistoryID) {
        this.contributionHistoryID = contributionHistoryID;
    }
    
}
