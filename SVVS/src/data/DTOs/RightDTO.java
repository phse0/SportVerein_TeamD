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
        if(model == null) return;
        extract(model);
    }
    
    @Override
    public void extract(IRight model) {
        this.id = model.getRightID();
        this.value = model.getValue();
        this.name = model.getName();
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public void setValue(long value) {
        this.value = value;
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
    public boolean equals(Object obj) {
        
        if(obj instanceof Long){
            
            Long check = ((Long)obj) & this.value;
            if(check > 0){
                return true;
            }
            return false;
            
        }else{
            return false;
        }
        
    }
    
    
}
