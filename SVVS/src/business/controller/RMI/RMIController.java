/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author phil
 */
public class RMIController {

    public static void main(String[] args) {
        try {
            
            IControllerFactory obj = new ControllerFactory();

            System.out.println("starting server...");

            Naming.rebind("rmi://localhost/SVVS", obj);

            System.out.println("Factory bound in the registry");
            
            
        } catch (RemoteException e) {
            System.out.println("error on remote communication");
            e.printStackTrace();
            return;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
            return;
        }

    }
}
