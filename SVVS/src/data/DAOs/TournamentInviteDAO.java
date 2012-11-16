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
import data.interfaces.models.ITournament;
import data.interfaces.models.ITournamentInvite;
import data.interfaces.models.ITrainingTeam;
import data.models.TournamentInvite;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class TournamentInviteDAO extends AbstractDAO<ITournamentInvite, ITournamentInviteDTO> implements ITournamentInviteDAO {

    private static ITournamentInviteDAO instance;

    private TournamentInviteDAO() {
        super("data.models.TournamentInvite");
    }

    public static ITournamentInviteDAO getInstance() {
        if (instance == null) {
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
    public List<ITournamentInvite> getBySportsman(Session s, ISportsman sportsman) {

        Query query = s.createQuery("FROM " + getTable() + " where sportsman = :sportsman");
        query.setParameter("sportsman", sportsman);
        return query.list();
    }

    @Override
    public List<ITournamentInvite> getByTournament(Session s, ITournament tournament) {

        Query query = s.createQuery("FROM " + getTable() + " where tournament = :tournament");
        query.setParameter("tournament", tournament);
        return query.list();
    }

    @Override
    public List<ITournamentInvite> getByTournamentAndTeam(Session s, ITournament tournament, ITrainingTeam team) {

        Query query = s.createQuery("FROM " + getTable() + " where tournament = :tournament AND team = :team");
        query.setParameter("tournament", tournament);
        query.setParameter("team", team);
        return query.list();
    }
    
    @Override
    public List<ITournamentInvite> getTeamsOfTournament(Session s, ITournament tournament) {

        Query query = s.createQuery("FROM " + getTable() + " where tournament = :tournament AND sportsman = :sportsman");
        query.setParameter("tournament", tournament);
        query.setParameter("sportsman", null);
        return query.list();
    }
    
     public List<ITournamentInviteDTO> getTeamsOfTournamentDTOs(Session s,  ITournament tournament){
        
        List<ITournamentInviteDTO> tid = new LinkedList<>();
        for(ITournamentInvite ti: getTeamsOfTournament(s,tournament)){
            tid.add(new TournamentInviteDTO(ti));            
        }
        
        return tid;
    }
    
    
    @Override
    public List<ITournamentInvite> getAllTeams(Session s) {

        Query query = s.createQuery("FROM " + getTable() + " where sportsman = :sportsman");
        query.setParameter("sportsman", null);
        return query.list();
    }
    
    public List<ITournamentInviteDTO> getAllTeamDTOs(Session s){
        
        List<ITournamentInviteDTO> tid = new LinkedList<>();
        for(ITournamentInvite ti: getAllTeams(s)){
            tid.add(new TournamentInviteDTO(ti));            
        }
        
        return tid;
    }
    

}
