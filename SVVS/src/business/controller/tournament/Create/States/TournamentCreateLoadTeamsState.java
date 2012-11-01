/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create.States;

import business.controller.tournament.Create.TournamentCreation;
import data.DAOs.TeamDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.IMatch;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentCreateLoadTeamsState implements ITournamentCreateState {

    TournamentCreation _creator;

    public TournamentCreateLoadTeamsState(TournamentCreation creator){
        _creator = creator;
    }

    @Override
    public LinkedList<ISport> loadSport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ITeam> loadTeams(ISport sport) {
        LinkedList<ITeam> teams = new LinkedList<ITeam>();
        for (ITeam iTeam : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
            teams.add(iTeam);
        }
        _creator.setCurState(new TournamentCreateState(_creator));
        return teams;
    }

    @Override
    public void CreateTournament(String name, String location, BigDecimal fee, String sportname, List<String> TeamNames) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
