/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.models.IContribution;

/**
 *
 * @author uubu
 */
public class ContributionDTO extends AbstractDTO<IContribution> implements IContributionDTO{

    private String name;
    private double value;

    public ContributionDTO(IContribution model) {
        if(model == null) return;
        extract(model);
    }
 
    @Override
    public final void extract(IContribution model){
        this.id = model.getContributionID();
        this.name = model.getName();
        this.value = model.getValue().doubleValue();
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getName();
    }

}
