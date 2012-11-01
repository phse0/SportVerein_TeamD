/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create.States;

import business.controller.tournament.Create.TournamentCreation;
import business.controller.tournament.TournamentController;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentCreateLoadSportState implements ITournamentCreateState {

    TournamentCreation _creator;

    public TournamentCreateLoadSportState(TournamentCreation creator) {
        _creator = creator;
    }

    @Override
    public LinkedList<ISportDTO> loadSport() {
        /* LinkedList<ISport> sports = new LinkedList<ISport>();

         for (ISport iS : SportDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
         sports.add(iS);
         }
         _creator.setCurState(new TournamentCreateLoadTeamsState(_creator));
         return sports;*/
        _creator.setCurState(new TournamentCreateLoadTeamsState(_creator));
        return TournamentController.getInstance().loadSport();
    }

    @Override
    public LinkedList<ITeamDTO> loadTeams(String sport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CreateTournament(String name, String location, BigDecimal fee, String sportname, List<String> TeamNames) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
