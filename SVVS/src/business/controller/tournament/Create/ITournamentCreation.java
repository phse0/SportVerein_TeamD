/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import java.rmi.Remote;
import java.util.LinkedList;
import java.util.List;

/**
 * Interface für den Context
 * @author phil
 */
public interface ITournamentCreation extends Remote  {
     public LinkedList<ITeam> loadTeams();

    public void CreateTournament(List<ITeam> Teams);

    public void AddMatches(LinkedList<IMatch> encounters);
}
