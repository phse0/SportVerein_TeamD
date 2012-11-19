/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.CORBA;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Kno
 */
public class CORBAClient {
    public static void main(String[] args)
    {
          String[] aaa = new String[]{"-ORBInitialHost", "localhost", "-ORBInitialPort", "2050"};
        try {
            ORB orb = ORB.init(aaa, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            _ergebnissbereitstellungStub ergebnissStub = (_ergebnissbereitstellungStub) ergebnissbereitstellungHelper.narrow(ncRef.resolve_str("Ergebnisse"));


            System.out.println(ergebnissStub.getErgebnisse("Eislauf", "huhn", "ka"));


        } catch (Exception e) {
            System.out.println("EX");
        }
    }
}
