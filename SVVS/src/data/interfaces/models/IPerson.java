/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface IPerson extends IModel {

    void addContributionHistory(IContributionHistory contributionHistory);

    Date getBirthdate();

    List<IContributionHistory> getContributionHistory();

    String getFirstname();

    String getLastname();

    String getMail();

    String getPassword();

    int getPersonID();

    String getPhone();

    int getRight();

    String getSex();

    String getUsername();

    void setBirthdate(Date birthdate);

    void setContributionHistory(List<IContributionHistory> contributionHistory);

    void setFirstname(String firstname);

    void setLastname(String lastname);

    void setMail(String mail);

    void setPassword(String password);

    void setPersonID(int personID);

    void setPhone(String phone);

    void setRight(int right);

    void setSex(String sex);

    void setUsername(String username);

    void addAddress(IAddress address);

    List<IAddress> getAddresses();

    void removeAddress(IAddress address);

    void removeContributionHistory(IContributionHistory contributionHistory);

    void setAddresses(List<IAddress> addresses);

    IAddress getMainAddress();

    void setMainAddress(IAddress mainAddress);
  
   
    
}
