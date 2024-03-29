/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.create.States;

import business.controller.JMS.MessageController;
import business.controller.RMI.AController;
import business.controller.person.PersonController;
import business.controller.person.create.PersonCreation;
import data.DAOs.PersonDAO;
import data.DAOs.RoleDAO;
import data.DAOs.RoleRightsDAO;
import data.DAOs.SportDAO;
import data.DAOs.SportsmanDAO;
import data.DTOs.PersonDTO;
import data.DTOs.SportsmanDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IManager;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRoleRights;
import data.interfaces.models.ISport;
import data.interfaces.models.ISportsman;
import data.models.Role;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.ehcache.distribution.RemoteCacheException;
import org.hibernate.Transaction;

/**
 *
 * @author phil
 */
public class PersonCreateAssignSportState extends AController implements IPersonCreateState {

    PersonCreation _creator;
    String authorID;

    public PersonCreateAssignSportState(PersonCreation creator) throws RemoteException {
        super();
        _creator = creator;
    }
   public PersonCreateAssignSportState(String authorid,PersonCreation creator) throws RemoteException {
        super();
        this.authorID = authorid;
        _creator = creator;
    }

    @Override
    public LinkedList<ICountryDTO> loadCountries() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISportDTO> loadSports() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PersonDTO CreatePerson(String firstname, String lastname,
            String sex, String phone, String mail,
            String username, String password, Date birthday, int right,
            String street, String postcode, String city, String country, int contributionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<IContributionDTO> loadContributions() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<String> sport, int personID) throws RemoteException {

        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        
        MessageController mc = null;
        
        try {
             mc = MessageController.getInstance(authorID);
        } catch (Exception ex) {
            Logger.getLogger(PersonCreateAssignSportState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (String sportname : sport) {
            //assigning values
            IPerson p = PersonController.getInstance().loadPersonWithIDNonDTO(personID);
            ISport s = PersonController.getInstance().loadSport(sportname);
            IRoleRights r = RoleRightsDAO.getInstance().getById(HibernateUtil.getCurrentSession(), 2);

            ISportsman sportsman = SportsmanDAO.getInstance().create();
            sportsman.setPerson(p);
            sportsman.setDepartment(s.getDepartment());
            sportsman.setSport(s);
            sportsman.setRoleRight(r);
            SportsmanDAO.getInstance().add(HibernateUtil.getCurrentSession(), sportsman);
            
            List<String> names = new LinkedList<>();
            
            names.add(s.getDepartment().getManager().getPerson().getUsername());
            
            mc.createSportsmanCreatedMessage( names ,new SportsmanDTO(sportsman));
        }

        tx.commit();
    }

    @Override
    public IPersonDTO CreatePersonDTO() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IPersonDTO SaveDTO(IPersonDTO dto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
