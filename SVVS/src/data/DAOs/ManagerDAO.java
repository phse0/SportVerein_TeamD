/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IManagerDAO;
import data.interfaces.models.IManager;

/**
 *
 * @author uubu
 */
public class ManagerDAO extends AbstractDAO<IManager> implements IManagerDAO {

    private static ManagerDAO instance;
    
    private ManagerDAO(){
        super("data.models.Manager");
    }
    
    private ManagerDAO getInstance(){
        if(instance == null){
            instance = new ManagerDAO();
        }
        return instance;
    }
    
    @Override
    public IManager create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
