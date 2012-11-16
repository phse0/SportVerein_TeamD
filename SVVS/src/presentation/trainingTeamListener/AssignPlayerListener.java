/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.trainingTeamListener;

import business.controller.team.playerToTeam.IPlayerToTeam;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import presentation.forms.AssignPlayerTrainingTeamDialog;
import presentation.tableModels.SportsManTrainingTeamTableModel;

/**
 *
 * @author Michael
 */
public class AssignPlayerListener implements ActionListener {

    JTable table;
    IPlayerToTeam assignController;
    AssignPlayerTrainingTeamDialog dialog;

    public AssignPlayerListener(AssignPlayerTrainingTeamDialog dialog, JTable table, IPlayerToTeam assignController) {
        this.table = table;
        this.assignController = assignController;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            ISportsmanTrainingTeamDTO addedPlayer = assignController.AddPlayerToTeam(dialog.getTrainingTeam().getId(),
                    dialog.getSportsman().getId(), dialog.getPosition());

            SportsManTrainingTeamTableModel tableModel = (SportsManTrainingTeamTableModel) table.getModel();
            dialog.removeSportsmanFromComboBox(addedPlayer.getSportsman());
            dialog.resetPosition();
            
            tableModel.addSportsman(addedPlayer);
            tableModel.fireTableDataChanged();

        } catch (RemoteException ex) {
            Logger.getLogger(AssignPlayerListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
