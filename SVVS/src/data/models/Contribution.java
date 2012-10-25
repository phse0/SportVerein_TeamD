/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.IContribution;
import java.math.BigDecimal;

/**
 *
 * @author uubu
 */
public class Contribution implements IContribution{
    
    protected int contributionID;
    protected String name;
    protected BigDecimal value;

    public Contribution() {
    }
    
    public int getContributionID() {
        return contributionID;
    }

    public void setContributionID(int contributionID) {
        this.contributionID = contributionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    
    
    
}
