/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.controller.person.AuthentificationController;
import data.DTOs.PersonDTO;
import data.DataFacade;
import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.IPersonDAO;
import data.interfaces.DTOs.IPersonDTO;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;

/**
 *
 * @author Media Markt
 */
public class TestE1 {
      public static void main(String[] args) throws NamingException, JMSException{
          IPersonDAO personDao = DataFacade.getPersonDAO();
        boolean ldapLoginSuccess = false;
        String username = "esp6462";
        String password = "";
             ldapLoginSuccess = AuthenticateLDAPPassword(username, password);  
      IPersonDTO person = new PersonDTO(personDao.getUserByUserName(username, HibernateUtil.getCurrentSession()));
        
   /*       Long right = person.getRight();
        //if person is null then there is no user with this username and we cannot authenticate 
        if (person != null) {

            //person.getPassword()!=null&&person.getPassword().equals(password)) 
            try {
                ldapLoginSuccess = AuthenticateLDAPPassword(username, password);
            } catch (NamingException ex) {
                ldapLoginSuccess = false;
                Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    */    if (ldapLoginSuccess == true) {
            HibernateUtil.getCurrentSession().close();
         //   System.out.println("Authentification succsess! Right = " + right);

         
            //return true;
        } else {
            System.out.println("Authentification failed");
            HibernateUtil.getCurrentSession().close();
          
        }

      }
       private static boolean AuthenticateLDAPPassword(String username, String password) throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        String base = "ou=fhv,ou=People,dc=uclv,dc=net";
        
        if(username.equals("tf-test")) {
            base = "ou=apps,dc=uclv,dc=net";
        }
        
        String dn = "uid=" + username + "," + base;

        //String ldapURL = "ldap://ldap.fhv.at:389";
        String ldapURL = "ldaps://ldap.fhv.at:636";

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, dn);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            @SuppressWarnings("unused")
            DirContext authContext = new InitialDirContext(env);
            System.out.println("Authentication LDAP Success!");
            return true;
        } catch (AuthenticationException authEx) {
            System.out.println("Authentication LDAP failed!");
            return false;

        } catch (NamingException namEx) {
            System.out.println("Something went wrong in LDAP!");
            namEx.printStackTrace();
            return false;
        }

    }

    public NamingEnumeration LDAPSearch(String filter, String search,
            DirContext dircontext) throws NamingException {
        // Attributes to give out
        String[] attributes = {"cn", "sn", "uid", "ou", "serialNumber", "Description", "userPassword"};
        // Adding Attributes to Searchcontrols
        SearchControls searchcontrols = new SearchControls();
        searchcontrols.setReturningAttributes(attributes);

        return dircontext.search(search, filter,
                searchcontrols);

        // call Search procedure


    }

    
}
