/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.person.edit.States;

import business.controller.person.PersonController;
import business.controller.person.edit.IPersonEdit;
import data.DAOs.RoleDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.ISportDTO;
import data.models.Role;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author phil
 */
class PersonEditAssignSportState implements IPersonEditState {

    IPersonEdit _editor;
    public PersonEditAssignSportState(IPersonEdit editor) {
        _editor = editor;
    }

    @Override
    public LinkedList<ISportDTO> loadSports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IPersonDTO editPerson(int PersonID, String firstname, String lastname, String sex, String phone, String mail, String username, String password, Date birthday, int right, String street, String postcode, String city, String country) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AssignToSport(LinkedList<String> sport, int personID) {
          for (String sportname : sport) {
             //assigning values
            Role role = new Role();
            role.setPerson(PersonController.getInstance().loadPersonWithIDNonDTO(personID));
            role.setSport(PersonController.getInstance().loadSport(sportname));
            
            RoleDAO.getInstance().add(HibernateUtil.getCurrentSession(), role);
        }
    }
    
}
