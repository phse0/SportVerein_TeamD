/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ISportDAO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ISport;
import data.models.Sport;

/**
 *
 * @author uubu
 */
public class SportDAO extends AbstractDAO<ISport, ISportDTO> implements ISportDAO{

    private static ISportDAO instance;
    
    private SportDAO(){
        super("data.models.Sport");
    }
    
    public static ISportDAO getInstance(){
        if ( instance == null){
            instance = new SportDAO();
        }
        return instance;
    }
    
    @Override
    public ISport create() {
        return new Sport();
    }

    @Override
    public ISportDTO extractDTO(ISport model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
