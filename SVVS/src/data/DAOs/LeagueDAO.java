/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.LeagueDTO;
import data.interfaces.DAOs.ILeagueDAO;
import data.interfaces.DTOs.ILeagueDTO;
import data.interfaces.models.ILeague;
import data.models.League;

/**
 *
 * @author uubu
 */
public class LeagueDAO extends AbstractDAO<ILeague, ILeagueDTO> implements ILeagueDAO {

    private static ILeagueDAO instance;
    
    private LeagueDAO(){
        super("data.models.League");
    }
    
    public static ILeagueDAO getInstance(){
        if (instance == null){
            instance = new LeagueDAO();
        }
        return instance;
    }
    
    @Override
    public ILeague create() {
        return new League();
    }

    @Override
    public ILeagueDTO extractDTO(ILeague model) {
        return new LeagueDTO(model);
    }
    
}
