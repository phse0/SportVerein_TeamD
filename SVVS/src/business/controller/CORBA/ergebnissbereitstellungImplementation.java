/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.CORBA;

import business.controller.RMI.IControllerFactory;
import data.interfaces.DTOs.ITournamentDTO;
import java.rmi.Naming;
import java.util.LinkedList;
import org.omg.CORBA.ORB;

/**
 *
 * @author Kno
 */
public class ergebnissbereitstellungImplementation extends ergebnissbereitstellungPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public String getErgebnisse(String sportart, String liga, String datum) {
        try {
            IControllerFactory controllerFactory = (IControllerFactory) Naming.lookup("rmi://localhost/SVVS");
            LinkedList<ITournamentDTO> tournaments = controllerFactory.loadTournamentController().loadTournaments();
            for(ITournamentDTO tournament: tournaments)
            {
                System.out.println(tournament.getDate() + "_" + datum + "||" + tournament.getSport().toString() + "_" + sportart + "||" + tournament.isFinished() + "_ true");
                if(tournament.getDate().equals(datum) && tournament.getSport().getName().equals(sportart) && tournament.isFinished())
                {
                  System.out.println("FOUND!");
                  if(tournament.getTeams().get(0).getLeague().getName().equals(liga))
                  {
                      System.out.println("superfound!");
                  }
                }
            }
            
            return "ddd";
        } catch (Exception e) {
        }
        return "";
    }

    @Override
    public boolean sindVollstaendig(String sportart, String liga, String datum) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
