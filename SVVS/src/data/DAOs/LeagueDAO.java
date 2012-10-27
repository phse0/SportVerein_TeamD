/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ILeagueDAO;
import data.interfaces.models.ILeague;
import data.models.League;

/**
 *
 * @author uubu
 */
public class LeagueDAO extends AbstractDAO<ILeague> implements ILeagueDAO {

    private static LeagueDAO instance;
    
    private LeagueDAO(){
        super("data.models.League");
    }
    
    public static LeagueDAO getInstance(){
        if (instance == null){
            instance = new LeagueDAO();
        }
        return instance;
    }
    
    @Override
    public ILeague create() {
        return new League();
    }
    
}
