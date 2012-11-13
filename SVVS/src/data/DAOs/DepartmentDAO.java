/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.DTOs.DepartmentDTO;
import data.interfaces.DAOs.IDepartmentDAO;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.ISport;
import data.models.Department;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author uubu
 */
public class DepartmentDAO extends AbstractDAO<IDepartment, IDepartmentDTO> implements IDepartmentDAO {

    private static IDepartmentDAO instance;

    private DepartmentDAO() {
        super("data.models.Department");
    }

    public static IDepartmentDAO getInstance() {
        if (instance == null) {
            instance = new DepartmentDAO();
        }
        return instance;
    }

    @Override
    public IDepartment create() {
        return new Department();
    }

    @Override
    public IDepartmentDTO extractDTO(IDepartment model) {
        return new DepartmentDTO(model);
    }

    public IDepartment getBySport(Session s, ISport model) {

        Query query = s.createQuery("FROM " + getTable() + " WHERE sport = :model");
        query.setParameter("model", model);
        return (IDepartment) query.uniqueResult();

    }
    
     @Override
    public IDepartment getById(Session s, int id) {

        Query query = s.createQuery("FROM " + getTable() + " where departmentID =:id");
        query.setInteger("id", id);
        return (IDepartment) query.uniqueResult();
    }
}
