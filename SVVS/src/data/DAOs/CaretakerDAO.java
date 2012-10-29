/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ICaretakerDAO;
import data.interfaces.models.ICaretaker;
import data.models.Caretaker;

/**
 *
 * @author uubu
 */
public class CaretakerDAO extends AbstractDAO<ICaretaker> implements ICaretakerDAO{

    private static ICaretakerDAO instance;
    
    private CaretakerDAO() {
        super("data.models.Address");
    }
    
    public static ICaretakerDAO getInstance(){
        if ( instance == null){
            instance = new CaretakerDAO();
        }
        return instance;
    }
    
    @Override
    public ICaretaker create() {
        return new Caretaker();
    }
    
}