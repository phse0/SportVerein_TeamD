/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.delete;

import business.controller.RMI.AController;
import data.DAOs.PersonDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IPersonDTO;
import java.rmi.RemoteException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */
public class PersonDelete extends AController implements IPersonDelete {

    public PersonDelete() throws RemoteException {
        super();
    }

    @Override
    public void removePerson(IPersonDTO person) throws RemoteException {

        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();
        PersonDAO.getInstance().removeDTO(s, person);
        tx.commit();
    }
}
