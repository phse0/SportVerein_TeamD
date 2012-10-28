/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ISportDAO;
import data.interfaces.models.ISport;
import data.models.Sport;

/**
 *
 * @author uubu
 */
public class SportDAO extends AbstractDAO<ISport> implements ISportDAO{

    private static SportDAO instance;
    
    private SportDAO(){
        super("data.models.Sport");
    }
    
    public static SportDAO getInstance(){
        if ( instance == null){
            instance = new SportDAO();
        }
        return instance;
    }
    
    @Override
    public ISport create() {
        return new Sport();
    }
    
}
