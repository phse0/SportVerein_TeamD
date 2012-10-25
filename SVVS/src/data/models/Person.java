/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.IContributionHistory;
import data.interfaces.IPerson;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Person implements IPerson{
    
    int personID;
    String firstname;
    String lastname;
    String sex;
    String phone;
    String mail;
    String username;
    String password;
    List<IContributionHistory> contributionHistory;
    int right;
    Date birthdate;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<IContributionHistory> getContributionHistory() {
        return contributionHistory;
    }

    public void setContributionHistory(List<IContributionHistory> contributionHistory) {
        this.contributionHistory = contributionHistory;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
   
    public void addContributionHistory(IContributionHistory contributionHistory){
        this.contributionHistory.add(contributionHistory);
    }
    
    public void removeContributionHistory(IContributionHistory contributionHistory){
        this.contributionHistory.remove(contributionHistory);
    }
}
