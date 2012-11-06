/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentTeamListener;

import business.controller.team.playerToTeam.IPlayerToTeam;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.AssignPlayerDialog;
import presentation.tableModels.SportsManTableModel;

/**
 *
 * @author Michael
 */
public class DeletePlayerListener implements ActionListener {

    JTable table;
    IPlayerToTeam assignController;
    AssignPlayerDialog dialog;

    public DeletePlayerListener(JTable table, IPlayerToTeam assignController, AssignPlayerDialog dialog) {
        this.table = table;
        this.assignController = assignController;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst einen Spieler aus, den Sie löschen möchten.");
        } else {
            int index = table.convertRowIndexToModel(table.getSelectedRow());
            SportsManTableModel sportsmanModel = (SportsManTableModel) table.getModel();
            ISportsmanTrainingTeamDTO deletingSportsman = sportsmanModel.getSportsmanDTO(index);

            try {
                assignController.RemovePlayerFromTeam(deletingSportsman);
                sportsmanModel.removeSportsman(deletingSportsman);
                sportsmanModel.fireTableDataChanged();
            } catch (RemoteException ex) {
                Logger.getLogger(DeletePlayerListener.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}