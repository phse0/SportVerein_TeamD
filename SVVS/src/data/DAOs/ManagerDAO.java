/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IManagerDAO;
import data.interfaces.models.IManager;
import data.models.Manager;

/**
 *
 * @author uubu
 */
public class ManagerDAO extends AbstractDAO<IManager> implements IManagerDAO {

    private static IManagerDAO instance;
    
    private ManagerDAO(){
        super("data.models.Manager");
    }
    
    public static IManagerDAO getInstance(){
        if(instance == null){
            instance = new ManagerDAO();
        }
        return instance;
    }
    
    @Override
    public IManager create() {
        return new Manager();
    }
    
}
