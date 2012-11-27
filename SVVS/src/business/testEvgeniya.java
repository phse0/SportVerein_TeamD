/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.controller.JMS.MessageController;
import business.messages.jms.interfaces.IMessage;
import data.DAOs.PersonDAO;
import data.DAOs.RightDAO;
import data.DAOs.SportsmanDAO;
import data.DTOs.PersonDTO;
import data.DTOs.SportsmanDTO;
import data.DataFacade;
import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.IPersonDAO;
import data.interfaces.DAOs.IRightDAO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISportsman;
import java.util.LinkedList;
import java.util.List;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */
public class testEvgeniya {

    private static InitialContext initialContext;
    private static ConnectionFactory connectionFactory;
    private static Connection connection;
    private static javax.jms.Session session;

    public static void main(String[] args) throws NamingException, JMSException {
        IPersonDAO personDao = DataFacade.getPersonDAO();

        MessageController mc = null;
        Session s = HibernateUtil.getCurrentSession();

        IPersonDTO personme = new PersonDTO(personDao.getUserByUserName("esp6462", HibernateUtil.getCurrentSession()));

        Long myright = personme.getRight();
        personme.setRight(127l);
        System.out.println("my rights are "+ personme.getRight());
        IPersonDTO personnotme = new PersonDTO(personDao.getUserByUserName("mfa6140", HibernateUtil.getCurrentSession()));

        Long notmyright = personnotme.getRight();
        try {
            mc = MessageController.getInstance();

            //mc.createQueue("mfa6140");


            IPerson p = PersonDAO.getInstance().getByUsername(s, "esp6462");

            ISportsman sm = SportsmanDAO.getInstance().getById(s, 10);

            List<String> names = new LinkedList<>();
            names.add("esp6462");

            mc.createSportsmanCreatedMessage(names, new SportsmanDTO(sm));

        /*    //List<IMessage> msg = mc.LoadMessages("esp6462");

            //  msg.

           System.out.println(msg.size());

            for (IMessage m : msg) {

                System.out.println(m.getText());
            }
*/

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        System.out.println("THE END");

    }
}
