/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person;

import business.controller.RMI.IController;
import java.rmi.Remote;

/**
 *
 * @author Media Markt
 */
public interface IAuthentificationController extends Remote, IController  {
  Long Authenticate(String Username, String password);
  
    
}
