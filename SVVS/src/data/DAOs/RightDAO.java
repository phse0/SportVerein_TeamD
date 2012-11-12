/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.RightDTO;
import data.interfaces.DAOs.IRightDAO;
import data.interfaces.DTOs.IRightDTO;
import data.interfaces.models.IPerson;
import data.interfaces.models.IRight;
import data.interfaces.models.ISport;
import data.models.Right;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class RightDAO extends AbstractDAO<IRight, IRightDTO> implements IRightDAO {

    private static IRightDAO instance;

    private RightDAO() {
        super("data.models.Right");
    }

    public static IRightDAO getInstance() {
        if (instance == null) {
            instance = new RightDAO();
        }
        return instance;
    }

    @Override
    public IRight create() {
        return new Right();
    }

    @Override
    public IRightDTO extractDTO(IRight model) {
        return new RightDTO(model);
    }

    @Override
    public Long getRightbyName(Session s, String name) {

        Query query = s.createQuery("FROM " + getTable() + " where name =:name");
        query.setString("name", name);
        IRight right = (IRight)query.uniqueResult();
        
        return right.getValue();


    }
}
