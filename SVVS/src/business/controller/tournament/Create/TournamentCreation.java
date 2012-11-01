/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import business.controller.tournament.Create.States.ITournamentCreateState;
import data.interfaces.models.IMatch;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Context für den Use Case neues Tournament, GUI sollte interface von dem
 * kriegen
 *
 * First LoadSport
 * Second LoadTeams
 * Third CreateTournament
 * @author phil
 */
public class TournamentCreation implements ITournamentCreation {

    ITournamentCreateState _curState;
    
    public ITournamentCreateState getCurState() {
        return _curState;
    }
    
    public void setCurState(ITournamentCreateState curState) {
        this._curState = curState;
    }
    
    public TournamentCreation(ITournamentCreateState curState) {
        _curState = curState;
    }
    
    @Override
    public LinkedList<ISport> loadSport() {
        return _curState.loadSport();
    }
    
    @Override
    public LinkedList<ITeam> loadTeams(ISport sport) {
        return _curState.loadTeams(sport);
    }
    
    @Override
    public void CreateTournament(String name, String location, BigDecimal fee, String sportname, List<String> TeamNames) {
        _curState.CreateTournament(name, location, fee, sportname, TeamNames);
    }
}