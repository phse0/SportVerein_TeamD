/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.CORBA;

import business.controller.RMI.IControllerFactory;
import data.DTOs.MatchDTO;
import data.interfaces.DTOs.IMatchDTO;
import data.interfaces.DTOs.ITournamentDTO;
import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;
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
        String returnstring = new String();
        try {
            IControllerFactory controllerFactory = (IControllerFactory) Naming.lookup("rmi://localhost/SVVS");
            LinkedList<ITournamentDTO> tournaments = controllerFactory.loadTournamentController().loadTournaments();
            for(ITournamentDTO tournament: tournaments)
            {
                System.out.println(tournament.getDate() + "_" + datum + "||" + tournament.getSport().toString() + "_" + sportart + "||" + tournament.isFinished() + "_ true");
                if(tournament.getDate().equals(datum) && tournament.getSport().getName().equals(sportart) && tournament.isFinished())
                {
                  System.out.println(tournament.getTeams().get(0).getLeague().getName() + "_" +liga);
                  if(tournament.getTeams().get(0).getLeague().getName().equals(liga))
                  {
                      returnstring += tournament.getName() +"***"+ tournament.getSport().toString() +"***"+ tournament.getDate() +"***"+ tournament.getLocation() +"***"+ tournament.getFee() + "~~~";
                      List<IMatchDTO> matches = tournament.getMatches();
                      for(IMatchDTO match: matches)
                      {
                          returnstring+= match.getDate() +"***"+ match.getLocation() +"***"+ match.getTeam1().getName() +"***"+ match.getTeam2().getName() +"***"+ match.getGoalsTeam1() +"***"+ match.getGoalsTeam2() + "~~~";
                      }
                  }
                }
            }
            
        } catch (Exception e) {
        }
        return returnstring;
    }

    @Override
    public boolean sindVollstaendig(String sportart, String liga, String datum) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
