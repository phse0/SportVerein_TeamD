/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.matchListeners;

import business.controller.tournament.edit.ITournamentEdit;
import data.interfaces.DTOs.IMatchDTO;
import data.interfaces.DTOs.ITournamentDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.forms.CreateMatchDialog;

/**
 *
 * @author Michael
 */
public class CreateNewMatchDialogListener implements ActionListener {

    ITournamentEdit controller;
    ITournamentDTO tournament;
    CreateMatchDialog dialog;

    public CreateNewMatchDialogListener(CreateMatchDialog dialog, ITournamentEdit controller, ITournamentDTO tournament) {
        this.controller = controller;
        this.tournament = tournament;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String error = isValide();
        if (!error.equals("")) {
            JOptionPane.showMessageDialog(null, "Speichern nicht möglich! \n"
                    + "Bitte korrigieren sie folgende Punkte: \n \n" + error);
        } else {

            Integer resultTeam1 = (!"".equals(dialog.getResultTeam1())) ? Integer.parseInt(dialog.getResultTeam1()) : null;
            Integer resultTeam2 = (!"".equals(dialog.getResultTeam2())) ? Integer.parseInt(dialog.getResultTeam2()) : null;

            try {
                IMatchDTO match = controller.AddMatch(tournament.getId(), dialog.getPlace(), Date.valueOf(dialog.getDate()), dialog.getTeam1(),
                        dialog.getTeam2(), resultTeam1, resultTeam2);
                
                JOptionPane.showMessageDialog(null, "Begegnung wurde gespeichert. \n");
                
                dialog.setMatch(match);
                dialog.dispose();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "Fehler ohne Sinn ist aufgetreten");
                ex.printStackTrace();
            }
        }
    }

    private String isValide() {

        String error = "";
        if (!"".equals(dialog.getResultTeam1())) {
            try {
                Integer.parseInt(dialog.getResultTeam1());
            } catch (Exception e) {
                error += "Ergebnis Team 1\n";
            }
        }

        if (!"".equals(dialog.getResultTeam2())) {
            try {
                Integer.parseInt(dialog.getResultTeam2());
            } catch (Exception e) {
                error += "Ergebnis Team 2\n";
            }
        }

        return error;

    }
}
