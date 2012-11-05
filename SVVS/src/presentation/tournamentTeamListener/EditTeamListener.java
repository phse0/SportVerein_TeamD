/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentTeamListener;

import business.controller.RMI.IControllerFactory;
import business.controller.team.playerToTeam.IPlayerToTeam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.AssignPlayerDialog;
import presentation.tableModels.TournamentTeamTableModel;

/**
 *
 * @author Michael
 */
public class EditTeamListener implements ActionListener {

    private IControllerFactory factory;
    private JTable table;

    public EditTeamListener(JTable table, IControllerFactory controllerFactory) {
        this.factory = controllerFactory;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst ein Team aus, dass sie bearbeiten möchten.");
        } else {
            int index = table.convertRowIndexToModel(table.getSelectedRow());
            TournamentTeamTableModel ttModel = (TournamentTeamTableModel) table.getModel();

            try {
                IPlayerToTeam playerAssignController = factory.loadPlayerToTeamController();
                AssignPlayerDialog dialog = new AssignPlayerDialog(null, true, playerAssignController, ttModel.getTournamentTeamDTO(index));
                dialog.setVisible(true);

                if (dialog.getTournamentTeam() != null) {
                    ttModel.updateTournamentTeamDTO(index, dialog.getTournamentTeam());
                    ttModel.fireTableDataChanged();
                }

            } catch (RemoteException ex) {
                Logger.getLogger(EditTeamListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
