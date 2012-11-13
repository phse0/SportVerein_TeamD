/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.departments;

import business.controller.RMI.IController;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ISportDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author phil
 */
public interface IDepartmentController extends Remote, IController {

    public List<IDepartmentDTO> loadDepartments() throws RemoteException;

    boolean isSportInDepartment(IDepartmentDTO dept, ISportDTO sport) throws RemoteException;
}
