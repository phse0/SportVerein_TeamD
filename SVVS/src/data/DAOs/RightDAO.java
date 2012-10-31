/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IRightDAO;
import data.interfaces.DTOs.IRightDTO;
import data.interfaces.models.IRight;
import data.models.Right;

/**
 *
 * @author uubu
 */
public class RightDAO extends AbstractDAO<IRight, IRightDTO> implements IRightDAO{

    private static IRightDAO instance;
    
    private RightDAO(){
        super("data.models.Right");
    }
    
    public static IRightDAO getInstance(){
        if ( instance == null){
            instance = new RightDAO();
        }
        return instance;
    }
    
    @Override
    public IRight create() {
        return new Right();
    }

    @Override
    public IRightDTO extractDTO(IRight model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
