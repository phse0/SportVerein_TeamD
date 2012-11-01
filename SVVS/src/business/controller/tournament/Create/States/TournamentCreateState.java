/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create.States;

import business.controller.tournament.Create.TournamentCreation;
import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.models.Tournament;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
class TournamentCreateState implements ITournamentCreateState {

    TournamentCreation _creator;

    public TournamentCreateState(TournamentCreation creator) {
        _creator = creator;
    }

    @Override
    public LinkedList<ISport> loadSport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ITeam> loadTeams(ISport sport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CreateTournament(String name, String location, BigDecimal fee,
            String sportname, List<String> TeamNames) {
        Tournament tournament = new Tournament();
        tournament.setName(name);
        tournament.setLocation(location);
        tournament.setFee(fee);
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);

        LinkedList<ITeam> teams = new LinkedList<ITeam>();
        //für jedes  team in der stringliste werden alle teams durchgegangen ob der name darin vorhanden ist
        for (String team : TeamNames) {
            for (ITeam it : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
                if (it.getName().equals(team)) {
                    teams.add(it);
                }
            }
        }

        tournament.setTeams(teams);

        TournamentDAO.getInstance().add(HibernateUtil.getCurrentSession(), tournament);

    }
}
