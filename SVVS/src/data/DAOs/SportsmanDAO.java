/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.SportsmanDTO;
import data.interfaces.DAOs.ISportsmanDAO;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRole;
import data.interfaces.models.ISport;
import data.interfaces.models.ISportsman;
import data.models.Sportsman;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class SportsmanDAO extends AbstractDAO<ISportsman, ISportsmanDTO> implements ISportsmanDAO {

    private static ISportsmanDAO instance;

    private SportsmanDAO() {
        super("data.models.Sportsman");
    }

    public static ISportsmanDAO getInstance() {
        if (instance == null) {
            instance = new SportsmanDAO();
        }
        return instance;
    }

    @Override
    public ISportsman create() {
        return new Sportsman();
    }

    @Override
    public ISportsmanDTO extractDTO(ISportsman model) {
        return new SportsmanDTO(model);
    }

    @Override
    public List<ISportsman> getByPerson(Session s, IPerson person) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE person = :person");
        query.setParameter("person", person);
        List<ISportsman> roles = new LinkedList<>();
        roles = query.list();

        if (roles.isEmpty()) {
            return null;
        }

        return roles;

    }

    @Override
    public ISportsman getByAll(Session s, IPerson person, IDepartment department, ISport sport) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE person = :person AND department = :department AND sport = :sport");
        query.setParameter("person", person);
        query.setParameter("department", department);
        query.setParameter("sport", sport);

        return (ISportsman) query.uniqueResult();

    }

    @Override
    public ISportsman getById(Session s, int id) {

        Query query = s.createQuery("FROM " + getTable() + " Where sportsmanID =:id");
        query.setInteger("id", id);
        return (ISportsman) query.uniqueResult();
    }
}
