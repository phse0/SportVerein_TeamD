/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.edit;

import business.controller.tournament.TournamentController;
import business.controller.tournament.edit.States.ITournamentEditState;
import business.controller.tournament.edit.States.TournamentEditLoadState;
import data.DAOs.MatchDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import data.models.Match;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * First loadtourment
 * second addmatches
 * the others do not need an order
 * @author phil
 */
public class TournamentEdit   extends UnicastRemoteObject  implements ITournamentEdit {

    ITournamentEditState _curState;

    public ITournamentEditState getCurState() {
        return _curState;
    }

    public void setCurState(ITournamentEditState _curState) {
        this._curState = _curState;
    }
    
      public TournamentEdit() throws RemoteException {
        super();
        setCurState(new TournamentEditLoadState(this));
    }
    
    @Override
    public LinkedList<ITournamentDTO> loadTournaments() throws RemoteException {
        return TournamentController.getInstance().loadTournaments();
    }

    @Override
    public LinkedList<ITeamDTO> loadTeams(String sport) throws RemoteException {
        return TournamentController.getInstance().loadTeams(sport);
    }

    @Override
    public ITournamentDTO loadTournament(int ID) throws RemoteException {
        return _curState.loadTournament(ID);
    }

    @Override
    public void AddMatch(int TournamentID, String location, Date date, String Team1Name,
    String Team2Name, Integer goalsTeam1, Integer goalsTeam2) throws RemoteException {
        _curState.AddMatch(TournamentID, location, date, Team1Name, Team2Name, goalsTeam1, goalsTeam2);
    }

    @Override
    public void EditTournament(int ID, String name, String location, BigDecimal fee, List<String> TeamNames) throws RemoteException {
        _curState.EditTournament(ID, name, location, fee, TeamNames);
    }

    @Override
    public void EditMatch(int MatchID, String location, Date date, String Team1Name, String Team2Name, Integer goalsTeam1, Integer goalsTeam2) throws RemoteException {
        List<IMatch> matches = MatchDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        IMatch match = null;
        for (IMatch im : matches) {
            if (im.getMatchID() == MatchID) {
                match = im;
            }
        }
        
        ITournament itour = match.getTournament();
        match.setTournament(itour);
        match.setLocation(location);

        match.setDate(date);
        match.setGoalsTeam1(goalsTeam1);
        match.setGoalsTeam2(goalsTeam2);

        for (ITeam team : itour.getTeams()) {
            if (team.getName().equals(Team1Name)) {
                match.setTeam1(team);
            }
        }

        for (ITeam team : itour.getTeams()) {
            if (team.getName().equals(Team2Name)) {
                match.setTeam2(team);
            }
        }

        MatchDAO.getInstance().update(HibernateUtil.getCurrentSession(), match);
    }
    
}
