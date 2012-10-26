/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface IRight extends IModel {

    String getName();

    int getRightID();

    long getValue();

    void setName(String name);

    void setRightID(int rightID);

    void setValue(long value);
    
}
