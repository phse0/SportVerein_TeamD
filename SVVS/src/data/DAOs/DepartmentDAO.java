/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.IDepartmentDAO;
import data.interfaces.models.IDepartment;
import data.models.Department;

/**
 *
 * @author uubu
 */
public class DepartmentDAO extends AbstractDAO<IDepartment> implements IDepartmentDAO{

    private static IDepartmentDAO instance;
    
    private DepartmentDAO(){
        super("data.models.Department");
    }
    
    public static IDepartmentDAO getInstance(){
        if ( instance == null){
            instance = new DepartmentDAO();
        }
        return instance;
    }

    @Override
    public IDepartment create() {
        return new Department();
    }
}
