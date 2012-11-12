/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.IPerson;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface IPersonDTO extends IDTO<IPerson>{

    String getBirthdate();

    String getFirstname();

    String getLastname();

    String getMail();

    IAddressDTO getMainAddress();

    String getPassword();

    String getPhone();

    Long getRight();

    String getSex();

    String getUsername();

    void setBirthdate(String birthdate);

    void setFirstname(String firstname);

    void setLastname(String lastname);

    void setMail(String mail);

    void setMainAddress(IAddressDTO mainAddress);

    void setPassword(String password);

    void setPhone(String phone);

    void setRight(Long right);

    void setSex(String sex);

    void setUsername(String username);

    IContributionDTO getContribution();

    String getContributionStatus();

    List<IDepartmentDTO> getDepartments();

    List<ISportDTO> getSports();

    void setContribution(IContributionDTO contribution);

    void setContributionStatus(String contributionStatus);

    void setDepartments(List<IDepartmentDTO> departments);

    void setSports(List<ISportDTO> sports);

    boolean hasRight(long right);

    
}
