/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentTeamListener;

import business.controller.RMI.IControllerFactory;
import business.controller.touramentTeam.ITournamentTeamController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.AssignPlayerTournamentTeamDialog;
import presentation.tableModels.TournamentInviteTableModel;
import presentation.trainingTeamListener.*;

/**
 *
 * @author Michael
 */
public class EditTournamentTeamListener implements ActionListener {

    private IControllerFactory factory;
    private JTable table;

    public EditTournamentTeamListener(JTable table, IControllerFactory controllerFactory) {
        this.factory = controllerFactory;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst ein Wettkampf Team aus, dass sie bearbeiten möchten.");
        } else {
            int index = table.convertRowIndexToModel(table.getSelectedRow());
            TournamentInviteTableModel ttModel = (TournamentInviteTableModel) table.getModel();

            try {
                ITournamentTeamController ttController = factory.loadTournamentTeamController();
                AssignPlayerTournamentTeamDialog dialog = new AssignPlayerTournamentTeamDialog(null, true, ttController, ttModel.getTournamentTeamDTO(index));
                dialog.setVisible(true);

                /*if (dialog.getTrainingTeam() != null) {
                    //ttModel.updateTournamentTeamDTO(index, dialog.getTrainingTeam());
                    ttModel.fireTableDataChanged();
                } */

            } catch (RemoteException ex) {
                Logger.getLogger(EditTeamListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
