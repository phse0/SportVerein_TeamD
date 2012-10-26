/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import java.math.BigDecimal;

/**
 *
 * @author uubu
 */
public interface IContribution {

    int getContributionID();

    String getName();

    BigDecimal getValue();

    void setContributionID(int contributionID);

    void setName(String name);

    void setValue(BigDecimal value);
    
}
