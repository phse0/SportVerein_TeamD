/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.IRight;

/**
 *
 * @author uubu
 */
public class Right implements IRight{
    
    protected int rightID;
    protected long value;
    protected String name;

    public Right() {
    }
    
    public int getRightID() {
        return rightID;
    }

    public void setRightID(int rightID) {
        this.rightID = rightID;
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
