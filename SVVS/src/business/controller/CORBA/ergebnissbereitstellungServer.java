/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.CORBA;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.Servant;

/**
 *
 * @author Kno
 */
public class ergebnissbereitstellungServer {

    public static void main(String[] args) {
        // String[] test = new String[]{"-ORBInitialPort", "2050"};
        try {
            ORB orb = ORB.init(new String[]{"-ORBInitialPort", "2050"}, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            ergebnissbereitstellungImplementation servant = new ergebnissbereitstellungImplementation();
            servant.setORB(orb);
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(servant);

            ergebnissbereitstellung href = ergebnissbereitstellungHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent cosName[] = ncRef.to_name("Ergebnisse");
            ncRef.rebind(cosName, href);
            System.out.println("Corbaereignissserver ready and waiting ...");
            orb.run();
        } catch (Exception e) {
            System.out.println("  Starten sie den ORB Connector zurerst!");
        }
    }
}
