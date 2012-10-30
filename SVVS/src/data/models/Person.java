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
public class Person implements IPerson {
    
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
    
    @Override
    public int getPersonID() {
        return personID;
    }

    @Override
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getName() {
        return this.firstname + ", " + this.lastname;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public List<IContributionHistory> getContributionHistory() {
        return contributionHistory;
    }

    @Override
    public void setContributionHistory(List<IContributionHistory> contributionHistory) {
        this.contributionHistory = contributionHistory;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public Date getBirthdate() {
        return birthdate;
    }

    @Override
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
   
    @Override
    public void addContributionHistory(IContributionHistory contributionHistory){
        this.contributionHistory.add(contributionHistory);
    }
    
    @Override
    public void removeContributionHistory(IContributionHistory contributionHistory){
        this.contributionHistory.remove(contributionHistory);
    }

    @Override
    public List<IAddress> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(List<IAddress> addresses) {
        this.addresses = addresses;
    }
    
    @Override
    public void addAddress(IAddress address){
        this.addresses.add(address);
    }
    
    @Override
    public void removeAddress(IAddress address){
        this.addresses.remove(address);
    }

    @Override
    public IAddress getMainAddress() {
        return mainAddress;
    }

    @Override
    public void setMainAddress(IAddress mainAddress) {
        this.mainAddress = mainAddress;
    }
    
}
