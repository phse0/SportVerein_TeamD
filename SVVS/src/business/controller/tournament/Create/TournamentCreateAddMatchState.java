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
class TournamentCreateAddMatchState extends UnicastRemoteObject implements ITournamentCreateState  {

    TournamentCreation _creator;
    public TournamentCreateAddMatchState(TournamentCreation creator) throws RemoteException{
        _creator = creator;
    }

    @Override
    public LinkedList<ITeam> loadTeams() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CreateTournament(List<ITeam> Teams) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AddMatches(LinkedList<IMatch> encounters) throws RemoteException {
                //do stuff here
    }
    
}
