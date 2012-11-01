/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.departments;

import business.controller.RMI.IController;
import data.DAOs.DepartmentDAO;
import data.DTOs.DepartmentDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.models.IDepartment;
import java.rmi.Remote;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
public class DepartmentController implements Remote, IController  {
    private static DepartmentController instance;

    private DepartmentController() {
    }

    public static DepartmentController getInstance() {
        if (instance == null) {
            return (instance = new DepartmentController());
        }
        return instance;
    }
    
    public LinkedList<IDepartmentDTO> loadDepartments(){
    LinkedList<IDepartmentDTO> deps = new LinkedList<IDepartmentDTO>();
        for (IDepartment iDep : DepartmentDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            deps.add(new DepartmentDTO(iDep));
        }
        return deps;
    }

}
