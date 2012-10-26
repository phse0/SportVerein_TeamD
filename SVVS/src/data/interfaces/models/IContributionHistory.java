/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface IContributionHistory {

    IContribution getContribution();

    int getMonth();

    IPerson getPerson();

    String getStatus();

    int getYear();

    void setContribution(IContribution contribution);

    void setMonth(int month);

    void setPerson(IPerson person);

    void setStatus(String status);

    void setYear(int year);
    
}
