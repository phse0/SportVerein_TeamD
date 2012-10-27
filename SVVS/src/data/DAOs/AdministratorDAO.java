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

    private static AdministratorDAO instance;
    
    private AdministratorDAO(){
        super("data.models.Administrator");
    }
    
    private static AdministratorDAO getInstance(){
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
