/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import business.controller.person.create.IPersonCreation;
import data.interfaces.DTOs.IPersonDTO;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import presentation.forms.CreatePersonDialog;

/**
 *
 * @author Michael
 */
public class SavePersonListener implements ActionListener {

    IPersonCreation creation;
    CreatePersonDialog _dialog;
    IPersonDTO person;

    public SavePersonListener(IPersonCreation creation, CreatePersonDialog dialog, IPersonDTO person) {
        this.creation = creation;
        _dialog = dialog;
        this.person = person;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //funktioniert die Speicherung?
        String error = isValide();
        if (!error.equals("")) {
            JOptionPane.showMessageDialog(null, "Speichern nicht möglich! \n"
                    + "Bitte korrigieren sie folgende Punkte: \n \n" + error);
        } else {
            try {
                //SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
                //Date birthdate = new Date(sdf.parse(_dialog.getBirthdate()).getTime());
                
                person.setFirstname(_dialog.getFirstName());
                person.setLastname(_dialog.getLastName());
                person.setSex(_dialog.getGender());
                person.setPhone(_dialog.getPhone());
                person.setMail(_dialog.getMail());
                person.setUsername(_dialog.getUserName());
                person.setPassword(_dialog.getPassword());
                person.setBirthdate(_dialog.getBirthdate());
                person.setRight(0);
                person.getMainAddress().setStreet(_dialog.getStreet());
                person.getMainAddress().setPostcode(_dialog.getPostCode());
                person.getMainAddress().setCity(_dialog.getCity());
                person.getMainAddress().setCountry(_dialog.getCountry());
                person.setContribution(_dialog.getContribution());
                person.setSports(_dialog.getSports());
                
                creation.SaveDTO(person);
                
                //IPersonDTO createdPerson = creation.CreatePerson(_dialog.getFirstName(), _dialog.getLastName(), _dialog.getGender(), _dialog.getPhone(), _dialog.getMail(), _dialog.getUserName(), _dialog.getPassword(), birthdate, 0, _dialog.getStreet(), _dialog.getPostCode(), _dialog.getCity(), _dialog.getLand(), _dialog.getContribution());
                //creation.AssignToSport(_dialog.getSports(), createdPerson.getId());
                
                JOptionPane.showMessageDialog(null, "Person wurde gespeichert. \n");
                _dialog.dispose();
            } catch (RemoteException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Fehler ohne Sinn ist aufgetreten");
                ex.printStackTrace();
            }
        }
    }

    private String isValide() {
        String errormessage = "";
        if (_dialog.getFirstName().equals("")) {
            errormessage += "Vorname \n";
        }
        if (_dialog.getLastName().equals("")) {
            errormessage += "Nachname \n";
        }
        if (_dialog.getGender() == null) {
            errormessage += "Geschlecht \n";
        }


        if (!_dialog.getBirthdate().equals("")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
                sdf.parse(_dialog.getBirthdate());
            } catch (Exception e) {
                errormessage += "Geburtsdatum \n";
            }
        }
        if (_dialog.getStreet().equals("")) {
            errormessage += "Straße \n";
        }
        if (_dialog.getPostCode().equals("")) {
            errormessage += "PLZ \n";
        }
        if (_dialog.getCity().equals("")) {
            errormessage += "Stadt \n";
        }
        if (_dialog.getLand().equals("")) {
            errormessage += "Land \n";
        }
        return errormessage;
    }
}
