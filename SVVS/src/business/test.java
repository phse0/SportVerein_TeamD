/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.controller.JMS.MessageController;
import business.messages.jms.interfaces.IMessage;
import data.DAOs.PersonDAO;
import data.DAOs.SportsmanDAO;
import data.DTOs.SportsmanDTO;
import data.hibernate.HibernateUtil;
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
public class test {
    private static InitialContext initialContext;
    private static ConnectionFactory connectionFactory;
    private static Connection connection;
    private static javax.jms.Session session;
    
    public static void main(String[] args) throws NamingException, JMSException{
        
        MessageController mc = null;
        
        try {
            mc = MessageController.getInstance();
            
            //mc.createQueue("mfa6140");
            
            Session s = HibernateUtil.getCurrentSession();
            
            IPerson p = PersonDAO.getInstance().getByUsername(s, "ffi0875");
            ISportsman sm = SportsmanDAO.getInstance().getById(s, 6);
            
            List<String> names = new LinkedList<>();
            names.add("ffi0875");
            
            mc.createSportsmanCreatedMessage(names,new SportsmanDTO(sm));
        
            List<IMessage> msg =  mc.LoadMessages("ffi0875");
            
            System.out.println(msg.size());
            
            for(IMessage m : msg){
                
                System.out.println(m.getText());
            }
            
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
        
        System.out.println("THE END");
        
    }
    
}
