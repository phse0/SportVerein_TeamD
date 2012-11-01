/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.SportsmanDTO;
import data.interfaces.DAOs.ISportsmanDAO;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.models.ISportsman;
import data.models.Sportsman;

/**
 *
 * @author uubu
 */
public class SportsmanDAO extends AbstractDAO<ISportsman, ISportsmanDTO> implements ISportsmanDAO{

    private static ISportsmanDAO instance;
    
    private SportsmanDAO(){
        super("data.models.Sportsman");
    }
    
    public static ISportsmanDAO getInstance(){
        if( instance==null){
            instance = new SportsmanDAO();
        }
        return instance;
    }
    
    @Override
    public ISportsman create() {
        return new Sportsman();
    }

    @Override
    public ISportsmanDTO extractDTO(ISportsman model) {
       return new SportsmanDTO(model);
    }
    
}
