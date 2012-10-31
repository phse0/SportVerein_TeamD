/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

/**
 *
 * @author uubu
 */
public interface IPersonDTO extends IDTO {

    String getBirthdate();

    String getFirstname();

    String getLastname();

    String getMail();

    IAddressDTO getMainAddress();

    String getPassword();

    String getPhone();

    int getRight();

    String getSex();

    String getUsername();

    void setBirthdate(String birthdate);

    void setFirstname(String firstname);

    void setLastname(String lastname);

    void setMail(String mail);

    void setMainAddress(IAddressDTO mainAddress);

    void setPassword(String password);

    void setPhone(String phone);

    void setRight(int right);

    void setSex(String sex);

    void setUsername(String username);

    
}
