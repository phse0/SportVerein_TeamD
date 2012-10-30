/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author phil
 */
public class TournamentCreateLoadState extends UnicastRemoteObject implements ITournamentCreateState {

    TournamentCreation _creator;
    public TournamentCreateLoadState(TournamentCreation creator) throws RemoteException{
        _creator = creator;
    }
    
    @Override
    public LinkedList<ITeam> loadTeams() throws RemoteException{
        /*
         * load Teams here
         */
        _creator.setCurState(new TournamentCreateState(_creator));        
        return new LinkedList<ITeam>();
    }

    @Override
    public void CreateTournament(List<ITeam> Teams) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AddMatches(LinkedList<IMatch> encounters) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
