/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.edit;

import business.controller.tournament.TournamentController;
import business.controller.tournament.edit.States.ITournamentEditState;
import business.controller.tournament.edit.States.TournamentEditLoadState;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.LinkedList;

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
    public LinkedList<ITournamentDTO> loadTournaments() {
        return TournamentController.getInstance().loadTournaments();
    }

    @Override
    public LinkedList<ITeamDTO> loadTeams(String sport) {
        return TournamentController.getInstance().loadTeams(sport);
    }

    @Override
    public ITournamentDTO loadTournament(int ID) {
        return _curState.loadTournament(ID);
    }

    @Override
    public void AddMatch(int TournamentID, String location, Date date, String Team1Name,
    String Team2Name, Integer goalsTeam1, Integer goalsTeam2) {
        _curState.AddMatch(TournamentID, location, date, Team1Name, Team2Name, goalsTeam1, goalsTeam2);
    }
    
}
