/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Interface für alle Funktionen 
 * @author phil
 */
public interface ITournamentCreateState{
    public LinkedList<ITeam> loadTeams()throws RemoteException;
    public void CreateTournament(/*Datum, Ort = Adresse?,Gebühr */List<ITeam> Teams)throws RemoteException;
    public void AddMatches(LinkedList<IMatch> encounters)throws RemoteException;
}
