/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.AdministratorDTO;
import data.interfaces.DAOs.IAdministratorDAO;
import data.interfaces.DTOs.IAdministratorDTO;
import data.interfaces.models.IAdministrator;
import data.models.Administrator;

/**
 *
 * @author uubu
 */
public class AdministratorDAO extends AbstractDAO<IAdministrator, IAdministratorDTO> implements IAdministratorDAO {

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

    @Override
    public IAdministratorDTO extractDTO(IAdministrator model) {
        return new AdministratorDTO(model);
    }
    
}
