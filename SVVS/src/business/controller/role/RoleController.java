/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role;

import business.controller.RMI.AController;
import data.DAOs.PersonDAO;
import data.DAOs.RoleDAO;
import data.DAOs.RoleRightsDAO;
import data.DTOs.RoleDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.IRoleRights;
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
    public List<IRoleRightsDTO> loadRoles() throws RemoteException {
        return RoleRightsDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession());
    }
    
    @Override
    public List<IRoleRightsDTO> loadRolesOfPerson(IPersonDTO person)throws RemoteException {
        
        List<IRoleRightsDTO> personroles = new LinkedList<>();
       
        for (IRoleRightsDTO roleright : loadRoles()) {
            
            if(person.hasRight(roleright.getRight())){
                personroles.add(roleright);
            } 
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

    public void EditPersonRole(IPersonDTO person, List<IRoleRightsDTO> roles) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
