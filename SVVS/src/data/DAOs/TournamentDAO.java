/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.TournamentDTO;
import data.interfaces.DAOs.ITournamentDAO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ITournament;
import data.models.Tournament;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class TournamentDAO extends AbstractDAO<ITournament, ITournamentDTO> implements ITournamentDAO {

    private static ITournamentDAO instance;

    private TournamentDAO() {
        super("data.models.Tournament");
    }

    public static ITournamentDAO getInstance() {
        if (instance == null) {
            instance = new TournamentDAO();
        }
        return instance;
    }

    @Override
    public ITournament create() {
        return new Tournament();
    }

    @Override
    public ITournamentDTO extractDTO(ITournament model) {
        return new TournamentDTO(model);
    }

    @Override
    public ITournament getById(Session s, int id) {

        Query query = s.createQuery("FROM " + getTable() + " Where tournamentID =:id");
        query.setInteger("id", id);
        return (ITournament) query.uniqueResult();
    }
}
