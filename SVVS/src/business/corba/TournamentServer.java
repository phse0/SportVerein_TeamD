/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.corba;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import CorbaTournament.Tournament.TounamentControll;
import CorbaTournament.Tournament.TounamentControllHelper;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author phil
 */
public class TournamentServer {

    public TournamentServer(String[] args) {
         try {
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
            System.out.println("Server ready and waiting ...");
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
    
    

    public static void main(String[] args) {
        new TournamentServer(args);
    }
}
