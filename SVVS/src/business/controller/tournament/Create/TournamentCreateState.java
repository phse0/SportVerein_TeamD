/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
class TournamentCreateState extends UnicastRemoteObject implements ITournamentCreateState  {

    TournamentCreation _creator;
    public TournamentCreateState(TournamentCreation creator) throws RemoteException{
        _creator = creator;
    }

    @Override
    public LinkedList<ITeam> loadTeams() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CreateTournament(List<ITeam> Teams) throws RemoteException {
        //do stuff here
        _creator.setCurState(new TournamentCreateAddMatchState(_creator));        
    }

    @Override
    public void AddMatches(LinkedList<IMatch> encounters) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
