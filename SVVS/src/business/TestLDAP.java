/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.controller.person.AuthentificationController;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Media Markt
 */
public class TestLDAP {

    public static void main(String args[]) throws NamingException {
        AuthentificationController ac = new AuthentificationController();
        //boolean b = ac.Authenticate("haaa","haaa");
        //boolean bb = ac.AuthenticateLDAPPassword("haaa","haaa");
        boolean bb = ac.AuthenticateLDAPPassword("Evgeniya Spiegel", "123456");
//boolean bb = ac.Authenticate("ArmandSpiegel","");
        System.out.println(bb);


    }
}
