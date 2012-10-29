/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ITournamentTeamDAO;
import data.interfaces.models.ITournamentTeam;
import data.models.TournamentTeam;

/**
 *
 * @author uubu
 */
public class TournamentTeamDAO extends AbstractDAO<ITournamentTeam> implements ITournamentTeamDAO{

    private static ITournamentTeamDAO instance;
    
    private TournamentTeamDAO(){
        super("data.models.TournamentTeam");
    }
    
    public static ITournamentTeamDAO getInstance(){
        if(instance == null){
            instance = new TournamentTeamDAO();
        }
        return instance;
    }
    
    @Override
    public ITournamentTeam create() {
        return new TournamentTeam();
    }
    
}
