/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.corba;

import CorbaTournament.Tournament.TounamentControllPOA;
import business.controller.tournament.TournamentController;
import data.DAOs.TournamentDAO;
import data.DTOs.TournamentDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IMatchDTO;
import data.interfaces.DTOs.ITournamentDTO;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentServant extends TounamentControllPOA {

    @Override
    public String loadTournaments() {
        String tournaments = "";
        try {

            List<ITournamentDTO> tdto = TournamentController.getInstance().loadTournaments();
            for (ITournamentDTO iTDTO : tdto) {
                tournaments += iTDTO.getId() + ";" + iTDTO.getName() + ";" + iTDTO.getLocation() + ";" + iTDTO.getDate() + "\n";
            }

        } catch (RemoteException re) {
            re.printStackTrace();
        }
        return tournaments;
    }

    @Override
    public String loadTournament(int id) {
        String matches = "";
        try {
            ITournamentDTO itdto = new TournamentDTO(TournamentController.getInstance().loadTournament(id));
            for (IMatchDTO imdto : itdto.getMatches()) {
                matches += imdto.getTeam1().getName() + ";"
                        + imdto.getTeam2().getName() + ";"
                        + imdto.getGoalsTeam1() + ";"
                        + imdto.getGoalsTeam2() + "\n";
            }

        } catch (RemoteException re) {
            re.printStackTrace();
        }
        return matches;
    }

    @Override
    public boolean isFinished(int id) {
        ITournamentDTO itdto = null;
        try {
            itdto = new TournamentDTO(TournamentController.getInstance().loadTournament(id));
        } catch (RemoteException re) {
            re.printStackTrace();
        }
        return itdto.isFinished();
    }
}
