/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IRight;

/**
 *
 * @author uubu
 */
public class Right implements IRight {
    
    protected int rightID;
    protected long value;
    protected String name;

    public Right() {
    }
    
    @Override
    public int getRightID() {
        return rightID;
    }

    @Override
    public void setRightID(int rightID) {
        this.rightID = rightID;
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
    
    
}
