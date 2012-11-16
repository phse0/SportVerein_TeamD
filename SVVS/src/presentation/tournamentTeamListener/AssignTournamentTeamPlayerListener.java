/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentTeamListener;

import presentation.trainingTeamListener.*;
import business.controller.touramentTeam.ITournamentTeamController;
import data.interfaces.DTOs.ISportsmanDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import presentation.forms.AssignPlayerTournamentTeamDialog;
import presentation.tableModels.SportsManTableModel;

/**
 *
 * @author Michael
 */
public class AssignTournamentTeamPlayerListener implements ActionListener {

    JTable table;
    ITournamentTeamController assignController;
    AssignPlayerTournamentTeamDialog dialog;

    public AssignTournamentTeamPlayerListener(AssignPlayerTournamentTeamDialog dialog, JTable table, ITournamentTeamController assignController) {
        this.table = table;
        this.assignController = assignController;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            //ISportsmanTrainingTeamDTO addedPlayer = assignController.AddPlayerToTeam(dialog.getTrainingTeam().getId(),
                    //dialog.getSportsman().getId(), dialog.getPosition());
            
            assignController.assignPlayer(dialog.getTournamentTeam().getTournament(), dialog.getTournamentTeam().getTeam(),
                    dialog.getSportsman());
            
            ISportsmanDTO addedPlayer = dialog.getSportsman();
            SportsManTableModel tableModel = (SportsManTableModel) table.getModel();
            dialog.removeSportsmanFromComboBox(addedPlayer);
                        
            tableModel.addSportsman(addedPlayer);
            tableModel.fireTableDataChanged();

        } catch (RemoteException ex) {
            Logger.getLogger(AssignPlayerListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
