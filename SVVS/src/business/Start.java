/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import CorbaTournament.Tournament.TounamentControll;
import CorbaTournament.Tournament.TounamentControllHelper;
import business.controller.RMI.ControllerFactory;
import business.controller.RMI.IControllerFactory;
import business.corba.TournamentServant;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author Michael
 */
public class Start {
    
    public static void main(String args[]) {
        
        try {

            java.rmi.registry.LocateRegistry.createRegistry(1099);
            IControllerFactory obj = new ControllerFactory();

            System.out.println("starting server...");

            Naming.rebind("rmi://localhost/SVVS", obj);

            System.out.println("RMI Factory bound in the registry");

            
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            TournamentServant servant = new TournamentServant();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(servant);
            TounamentControll href = TounamentControllHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent cosName[] = ncRef.to_name("TournamentObject");
            ncRef.rebind(cosName, href);
            System.out.println("ORB ready and waiting ...");
            orb.run();
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        
    }
    
}
