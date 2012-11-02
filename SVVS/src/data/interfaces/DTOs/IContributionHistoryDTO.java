/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IContributionHistory;

/**
 *
 * @author uubu
 */
public interface IContributionHistoryDTO extends IDTO<IContributionHistory> {

    IContributionDTO getContribution();

    int getMonth();

    String getStatus();

    int getYear();

    void setContribution(IContributionDTO contribution);

    void setMonth(int month);

    void setStatus(String status);

    void setYear(int year);

}
