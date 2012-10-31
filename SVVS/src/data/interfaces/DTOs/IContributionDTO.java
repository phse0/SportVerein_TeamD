/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IContribution;

/**
 *
 * @author uubu
 */
public interface IContributionDTO extends IDTO<IContribution>{
    
    String getName();
    void setName(String name);
    
    double getValue();
    void setValue(double value);
}
