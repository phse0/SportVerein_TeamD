/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.edit.States;

import business.controller.tournament.TournamentController;
import business.controller.tournament.edit.TournamentEdit;
import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentEditState implements ITournamentEditState  {
     TournamentEdit _editor;

    public TournamentEditState(TournamentEdit editor) {
        _editor = editor;
    }

    @Override
    public ITournamentDTO loadTournament(int ID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void EditTournament(int ID, String name, String location, BigDecimal fee, List<String> TeamNames) throws RemoteException {
 
        ITournament tournament = TournamentController.getInstance().loadTournament(ID);
        tournament.setName(name);
        tournament.setLocation(location);
        tournament.setFee(fee);

        List<ITeam> teams = tournament.getTeams();
        //für jedes  team in der stringliste werden alle teams durchgegangen ob der name darin vorhanden ist
        for (String team : TeamNames) {
            for (ITeam it : TeamDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
                if (it.getName().equals(team)) {
                    teams.add(it);
                }
            }
        }

        tournament.setTeams(teams);

        TournamentDAO.getInstance().update(HibernateUtil.getCurrentSession(), tournament);
        _editor.setCurState(new TournamentEditAddMatchState(_editor));
    }

    @Override
    public void AddMatch(int TournamentID, String location, Date date, String Team1Name, String Team2Name, Integer goalsTeam1, Integer goalsTeam2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
