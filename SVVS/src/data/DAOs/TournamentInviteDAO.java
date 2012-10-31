/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ITournamentInviteDAO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.models.ITournamentInvite;
import data.models.TournamentInvite;

/**
 *
 * @author uubu
 */
public class TournamentInviteDAO extends AbstractDAO<ITournamentInvite,ITournamentInviteDTO> implements ITournamentInviteDAO {

     private static ITournamentInviteDAO instance;
    
    private TournamentInviteDAO(){
        super("data.models.TournamentInvite");
    }
    
    public static ITournamentInviteDAO getInstance(){
        if(instance == null){
            instance = new TournamentInviteDAO();
        }
        return instance;
    }
    
    @Override
    public ITournamentInvite create() {
        return new TournamentInvite();
    }

    @Override
    public ITournamentInviteDTO extractDTO(ITournamentInvite model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
