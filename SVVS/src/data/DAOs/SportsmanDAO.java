/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ISportsmanDAO;
import data.interfaces.models.ISportsman;
import data.models.Sportsman;

/**
 *
 * @author uubu
 */
public class SportsmanDAO extends AbstractDAO<ISportsman> implements ISportsmanDAO{

    private static SportsmanDAO instance;
    
    private SportsmanDAO(){
        super("data.models.Sportsman");
    }
    
    public static SportsmanDAO getInstance(){
        if( instance==null){
            instance = new SportsmanDAO();
        }
        return instance;
    }
    
    @Override
    public ISportsman create() {
        return new Sportsman();
    }
    
}
