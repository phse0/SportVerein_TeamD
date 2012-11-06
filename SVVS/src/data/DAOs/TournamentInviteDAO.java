/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.TournamentInviteDTO;
import data.interfaces.DAOs.ITournamentInviteDAO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITournamentInvite;
import data.models.TournamentInvite;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

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
        return new TournamentInviteDTO(model);
    }
    
     @Override
    public List<ITournamentInvite> getBySportsman(Session s, ISportsman sportsman){
        
        Query query = s.createQuery("FROM " + getTable() + " where sportsman = :sportsman");
        query.setParameter("sportsman", sportsman);
        return query.list();
    }
    
}
