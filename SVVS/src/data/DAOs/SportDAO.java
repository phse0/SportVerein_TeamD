/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.SportDTO;
import data.interfaces.DAOs.ISportDAO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.models.ISport;
import data.models.Sport;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class SportDAO extends AbstractDAO<ISport, ISportDTO> implements ISportDAO {

    private static ISportDAO instance;

    private SportDAO() {
        super("data.models.Sport");
    }

    public static ISportDAO getInstance() {
        if (instance == null) {
            instance = new SportDAO();
        }
        return instance;
    }

    @Override
    public ISport create() {
        return new Sport();
    }

    @Override
    public ISportDTO extractDTO(ISport model) {
        return new SportDTO(model);
    }

    @Override
    public ISport getByName(Session s, String name) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE name = :name");
        query.setString("name", name);
        return (ISport) query.uniqueResult();
    }

    @Override
    public ISport getById(Session s, int id) {

        Query query = s.createQuery("FROM " + getTable() + " Where sportID =:id");
        query.setInteger("id", id);
        return (ISport) query.uniqueResult();
    }

    @Override
    public ISport saveDTOgetModel(Session s, ISportDTO dto) {

        if (dto == null) {
            return null;
        }

        ISport sport = (dto.getId() == 0) ? null : getById(s, dto.getId());

        if (sport == null) {
            sport = create();
        }
        sport.setName(dto.getName());
        sport.setMaxPlayers(dto.getMaxPlayers());

        s.saveOrUpdate(sport);

        return sport;
    }

    @Override
    public ISportDTO saveDTO(Session s, ISportDTO dto) {

        return new SportDTO(saveDTOgetModel(s, dto));
    }
}
