/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role;

import business.controller.RMI.AController;
import data.DAOs.PersonDAO;
import data.DAOs.RoleDAO;
import data.DTOs.RoleDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

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
    
    public List<IRoleDTO> loadRolesOfPerson(IPerson person)throws RemoteException {
        List<IRoleDTO> personroles = new LinkedList<>();
        for (IRole role : RoleDAO.getInstance().getByPerson(HibernateUtil.getCurrentSession(), person)) {
            personroles.add(new RoleDTO(role));
        }
        return personroles;
    }

    @Override
    public void EditPersonRole(IPerson person, List<IRole> roles) throws RemoteException {
        for (IRole iRole : roles) {
            iRole.setPerson(person);
            RoleDAO.getInstance().update(HibernateUtil.getCurrentSession(), iRole);
        }
        
        person.setRoles(roles);
        PersonDAO.getInstance().update(HibernateUtil.getCurrentSession(), person);
    }
    
}
