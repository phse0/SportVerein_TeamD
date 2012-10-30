/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Context für den Use Case neues Tournament, GUI sollte interface von dem kriegen
 * @author phil
 */
public class TournamentCreation {
    ITournamentCreateState _curState;

    public ITournamentCreateState getCurState() {
        return _curState;
    }

    public void setCurState(ITournamentCreateState curState) {
        this._curState = curState;
    }
    
    public TournamentCreation(ITournamentCreateState curState){
    _curState = curState;
    }
    
    public LinkedList<ITeam> loadTeams() throws RemoteException {
        return _curState.loadTeams();
    }

    public void CreateTournament(List<ITeam> Teams) throws RemoteException {
        _curState.CreateTournament(Teams);
    }

    public void AddMatches(LinkedList<IMatch> encounters) throws RemoteException {
       _curState.AddMatches(encounters);
    }
}
