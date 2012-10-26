/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IAddress;
import data.interfaces.models.IContributionHistory;
import data.interfaces.models.IPerson;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author uubu
 */
public class Person implements IPerson{
    
    protected int personID;
    protected String firstname;
    protected String lastname;
    protected String sex;
    protected String phone;
    protected String mail;
    protected String username;
    protected String password;
    protected List<IContributionHistory> contributionHistory;
    protected List<IAddress> addresses;
    protected IAddress mainAddress;
    protected int right;
    protected Date birthdate;

    public Person() {
    }
    
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

    public List<IAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<IAddress> addresses) {
        this.addresses = addresses;
    }
    
    public void addAddress(IAddress address){
        this.addresses.add(address);
    }
    
    public void removeAddress(IAddress address){
        this.addresses.remove(address);
    }

    public IAddress getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(IAddress mainAddress) {
        this.mainAddress = mainAddress;
    }
    
}
