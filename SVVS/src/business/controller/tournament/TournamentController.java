/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament;

import data.interfaces.models.IMatch;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import data.models.Tournament;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentController {
    
        
    /**
     * Returns a list of the current Tournaments
     * @return a List of Tournaments beginning from the current day
     */
    public LinkedList<ITournament> LoadCurrentTournaments(){
    LinkedList<ITournament> iTournaments = new LinkedList<ITournament>();
    //loading all Tourmanets from current Date
    return iTournaments;
    }
    
    
    /**
     * Creates a new Tournament
     * @return the new created Tournament
     */
    public ITournament CreateTournament(/*add necessary data here:
     * Datum, Ort, [Gast- und Heim-] Mannschaften,
     * Wettkampfgebühr, Begegnungen, etc.*/){
    return new Tournament();
    }
    
    /**
     * Adds A Participant to an Existing Tournament
     * @param TounamentID 
     */
    public void AddParticipant(int TounamentID/*add his data here*/){
    
    }
    
    /**
     * Adds a result to a match
     * @param MatchID
     * @param ResultOponent
     * @param ResultHome 
     */
    public void AddResult(int MatchID, int ResultOponent, int ResultHome){
    
    }
    
    /**
     * Loads a Tournament and Returns the List of Matches
     * @param TournamentID
     * @return a List of Matches
     */
    public List<IMatch> loadMatches(int TournamentID){
    ITournament curTournament = null; //addloadingstuff
    return curTournament.getMatches();
    }
    
}
