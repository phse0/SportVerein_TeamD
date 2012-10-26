/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface ITournamentTeam extends ITrainingTeam{

    ILeague getLeague();

    void setLeague(ILeague league);
    
}
