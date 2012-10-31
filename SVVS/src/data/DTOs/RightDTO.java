/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IRightDTO;
import data.interfaces.models.IRight;

/**
 *
 * @author uubu
 */
public class RightDTO extends AbstractDTO<IRight> implements IRightDTO{

    protected long value;
    protected String name;
    
    public RightDTO(IRight model){
        extract(model);
    }
    
    @Override
    public void extract(IRight model) {
        this.id = model.getRightID();
        this.value = model.getValue();
        this.name = model.getName();
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
