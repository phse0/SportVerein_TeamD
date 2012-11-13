/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IDepartment;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface IDepartmentDTO extends IDTO<IDepartment> {

    String getName();
    
    void setName(String name);

    List<ISportDTO> getSports();

    void setSports(List<ISportDTO> sports);
}
