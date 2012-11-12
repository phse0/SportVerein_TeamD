/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.role;

import business.controller.RMI.AController;
import data.DAOs.AdministratorDAO;
import data.DAOs.CaretakerDAO;
import data.DAOs.CoachDAO;
import data.DAOs.ManagerDAO;
import data.DAOs.PersonDAO;
import data.DAOs.RoleDAO;
import data.DAOs.RoleRightsDAO;
import data.DAOs.SportsmanDAO;
import data.DTOs.RoleDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.DTOs.IRoleRightsDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.IAdministrator;
import data.interfaces.models.ICaretaker;
import data.interfaces.models.ICoach;
import data.interfaces.models.IManager;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.IRoleRights;
import data.interfaces.models.ISportsman;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

/**
 *
 * @author phil
 */
public class RoleController extends AController implements IRoleController {

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
    public List<IRoleRightsDTO> loadRoleRights() throws RemoteException {
        return RoleRightsDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession());
    }

    @Override
    public List<IRoleRightsDTO> loadRoleRightsOfPerson(IPersonDTO person) throws RemoteException {

        List<IRoleRightsDTO> personroles = new LinkedList<>();

        for (IRoleRightsDTO roleright : loadRoleRights()) {

            if (person.hasRight(roleright.getRight())) {
                personroles.add(roleright);
            }
        }
        return personroles;
    }

    /* public void EditPersonRole(IPerson person, List<IRole> roles) throws RemoteException {
     for (IRole iRole : roles) {
     iRole.setPerson(person);
     RoleDAO.getInstance().update(HibernateUtil.getCurrentSession(), iRole);
     }

     person.setRoles(roles);
     PersonDAO.getInstance().update(HibernateUtil.getCurrentSession(), person);
     }*/
    @Override
    public void EditPersonRole(IPersonDTO person, List<IRoleRightsDTO> roles, IDepartmentDTO department, ISportDTO sport) {
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        IPerson p = PersonDAO.getInstance().getById(HibernateUtil.getCurrentSession(), person.getId());
        for (IRoleRightsDTO iRRD : roles) {
            IRole temp = null;
            switch (iRRD.getName()) {
                case "Manager":
                    temp = ManagerDAO.getInstance().getByPerson(HibernateUtil.getCurrentSession(), p);
                    if (temp == null) {
                        IManager manager = ManagerDAO.getInstance().create();
                        manager.setPerson(p);
                        ManagerDAO.getInstance().add(HibernateUtil.getCurrentSession(), manager);
                    }
                    break;
                case "Sportler":
                    for (ISportsman rollll : SportsmanDAO.getInstance().getByPerson(HibernateUtil.getCurrentSession(), p)) {
                        temp = rolll;
                        if (temp == null) {
                            ISportsman sportsman = SportsmanDAO.getInstance().create();
                            sportsman.setPerson(p);
                            SportsmanDAO.getInstance().add(HibernateUtil.getCurrentSession(), sportsman);
                        }
                    }
                    break;
                case "Trainer":
                    temp = CoachDAO.getInstance().getByPerson(person);
                    if (temp == null) {
                        ICoach coach = CoachDAO.getInstance().create();
                        coach.setPerson(p);
                        CoachDAO.getInstance().add(HibernateUtil.getCurrentSession(), coach);
                    }
                    break;
                case "Admin":
                    temp = AdministratorDAO.getInstance().getByPerson(person);
                    if (temp == null) {
                        IAdministrator administrator = AdministratorDAO.getInstance().create();
                        administrator.setPerson(p);
                        AdministratorDAO.getInstance().add(HibernateUtil.getCurrentSession(), administrator);
                    }
                    break;
                case "Verwalter":
                    temp = CaretakerDAO.getInstance().getByPerson(person);
                    if (temp == null) {
                        ICaretaker caretaker = CaretakerDAO.getInstance().create();
                        caretaker.setPerson(p);
                        CaretakerDAO.getInstance().add(HibernateUtil.getCurrentSession(), caretaker);
                    }
                    break;
            }
        }
        tx.commit();
    }

    @Override
    public List<IRoleDTO> loadRolesOfPerson(IPersonDTO person) throws RemoteException {
        LinkedList<IRoleDTO> roles = new LinkedList<>();
        for (IRole ir : RoleDAO.getInstance().getByPerson(HibernateUtil.getCurrentSession(), PersonDAO.getInstance().getById(HibernateUtil.getCurrentSession(), person.getId()))) {
            roles.add(new RoleDTO(ir));
        }
        return roles;
    }
}
