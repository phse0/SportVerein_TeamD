/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IAdministratorDAO;
import data.interfaces.models.IAdministrator;
import data.models.Administrator;

/**
 *
 * @author uubu
 */
public class AdministratorDAO extends AbstractDAO<IAdministrator> implements IAdministratorDAO {

    private static IAdministratorDAO instance;
    
    private AdministratorDAO(){
        super("data.models.Administrator");
    }
    
    public static IAdministratorDAO getInstance(){
        if ( instance == null){
            instance = new AdministratorDAO();
        }
        return instance;
    }
    
    @Override
    public IAdministrator create() {
        return new Administrator();
    }
    
}
