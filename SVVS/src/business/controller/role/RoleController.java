/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role;

import business.controller.RMI.AController;
import data.DAOs.RoleDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IRoleDTO;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class RoleController  extends AController implements IRoleController {

    private static RoleController instance;

    private RoleController() throws RemoteException {
        super();
    }

    public static RoleController getInstance() throws RemoteException {
        if (instance == null) {
            return (instance = new RoleController());
        }
        return instance;
    }
    
    @Override
    public List<IRoleDTO> loadRoles() throws RemoteException {
        return RoleDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession());
    }
    
}
