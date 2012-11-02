/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.personListeners;

import business.controller.person.create.IPersonCreation;
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import presentation.forms.CreatePersonDialog;

/**
 *
 * @author Michael
 */
public class SavePersonListener implements ActionListener {

    IPersonCreation creation;
    CreatePersonDialog _dialog;

    public SavePersonListener(IPersonCreation creation, CreatePersonDialog dialog) {
        this.creation = creation;
        _dialog = dialog;
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
                creation.CreatePerson(_dialog.getFirstName(), _dialog.getLastName(), _dialog.getGender(), _dialog.getPhone(), _dialog.getMail(), _dialog.getUserName(), _dialog.getPassword(), new java.sql.Date(new java.util.Date(_dialog.getBirthdate()).getTime()), 0, _dialog.getStreet(), _dialog.getPostCode(), _dialog.getCity(), _dialog.getLand(), _dialog.getContribution());
                JOptionPane.showMessageDialog(null, "Person wurde gespeichert. \n");
                _dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Fehler ohne Sinn ist aufgetreten");
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
                new java.sql.Date(new java.util.Date(_dialog.getBirthdate()).getTime());
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
        if (_dialog.getContribution() == -1) {
            errormessage += "Mittgliedsbeitrag \n";
        }
        return errormessage;
    }
}
