/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.TournamentTeamDTO;
import data.interfaces.DAOs.ITournamentTeamDAO;
import data.interfaces.DTOs.ITournamentTeamDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITournamentTeam;
import data.models.TournamentTeam;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class TournamentTeamDAO extends AbstractDAO<ITournamentTeam, ITournamentTeamDTO> implements ITournamentTeamDAO {

    private static ITournamentTeamDAO instance;

    private TournamentTeamDAO() {
        super("data.models.TournamentTeam");
    }

    public static ITournamentTeamDAO getInstance() {
        if (instance == null) {
            instance = new TournamentTeamDAO();
        }
        return instance;
    }

    @Override
    public ITournamentTeam create() {
        return new TournamentTeam();
    }

    @Override
    public ITournamentTeamDTO extractDTO(ITournamentTeam model) {
        return new TournamentTeamDTO(model);
    }

    public List<ITournamentTeam> getBySport(Session s, ISport model) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE sport = :model");
        query.setParameter("model", model);
        return query.list();
    }
}
