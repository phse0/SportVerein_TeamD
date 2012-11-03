/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentListeners;

import business.controller.tournament.edit.ITournamentEdit;
import data.interfaces.DTOs.ITournamentDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.forms.EditTournamentDialog;

/**
 *
 * @author Michael
 */
public class EditTournamentDialogListener implements ActionListener {

    private EditTournamentDialog dialog;
    private ITournamentEdit editController;
    private ITournamentDTO tournament;

    public EditTournamentDialogListener(EditTournamentDialog dialog, ITournamentEdit controller,
            ITournamentDTO tournament) {
        this.dialog = dialog;
        this.editController = controller;
        this.tournament = tournament;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String error = isValide();
        if(error.equals("")) {
            try {
                ITournamentDTO tDTO = editController.EditTournament(tournament.getId(), dialog.getTournamentName(), 
                        dialog.getPlace(), Date.valueOf(dialog.getDate()), new BigDecimal(dialog.getFee()), null);
                
                JOptionPane.showMessageDialog(null, "Tournament wurde erfolgreich erstellt.");
                
                dialog.setTournament(tDTO);
                dialog.dispose();
            } catch (RemoteException ex) {
                Logger.getLogger(EditTournamentDialogListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String isValide() {
        String error = "";

        if (dialog.getName().equals("")) {
            error += "Name \n";
        }
        if (dialog.getPlace().equals("")) {
            error += "Ort \n";
        }
        try {
            new BigDecimal(dialog.getFee());
        } catch (Exception ex) {
            error += "Gebühr + \n";
        }

        return error;
    }
}
