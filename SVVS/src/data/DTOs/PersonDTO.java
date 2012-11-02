/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.IAddressDTO;
import data.interfaces.DTOs.IContributionDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.models.IPerson;

/**
 *
 * @author uubu
 */
public class PersonDTO extends AbstractDTO<IPerson> implements IPersonDTO{

    protected String firstname;
    protected String lastname;
    protected String sex;
    protected String phone;
    protected String mail;
    protected String username;
    protected String password;
    protected IAddressDTO mainAddress;
    protected int right;
    protected String birthdate;
    
    protected IContributionDTO contribution;
    //protected List<ISportDTO> sports;
    
    public PersonDTO(IPerson person) {
        //sports = new LinkedList<>();
        extract(person);
    }
    
    @Override
    public void extract(IPerson model) {
        this.id = model.getPersonID();
        this.firstname = model.getFirstname();
        this.lastname = model.getLastname();
        this.sex = model.getSex();
        this.phone = model.getPhone();
        this.mail=model.getMail();
        this.username = model.getUsername();
        this.password = model.getPassword();
        this.mainAddress = new AddressDTO(model.getMainAddress());
        this.right = model.getRight();
        this.birthdate = (model.getBirthdate() == null) ? "" : model.getBirthdate().toString();
        
        this.contribution = (model.getLastContribution() == null) ? null : new ContributionDTO(model.getLastContribution());
    
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
    public IAddressDTO getMainAddress() {
        return mainAddress;
    }

    @Override
    public void setMainAddress(IAddressDTO mainAddress) {
        this.mainAddress = mainAddress;
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
    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
        
}
