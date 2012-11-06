/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tournamentListeners;

import business.controller.RMI.IControllerFactory;
import business.controller.team.ITeamController;
import business.controller.tournament.edit.ITournamentEdit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import presentation.forms.EditTournamentDialog;
import presentation.forms.WettkampfDeatilAnsicht;
import presentation.tableModels.TournamentTableModel;

/**
 *
 * @author Kno
 */
public class ShowTournamentListener implements ActionListener {

    JTable _table;
    IControllerFactory factory;
    ITeamController teamcontroller;
    
    public ShowTournamentListener(JTable table, IControllerFactory factory, ITeamController teamcontroller) {
        _table = table;
        this.factory = factory;
        this.teamcontroller = teamcontroller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst einen Wettbewerb aus, die sie bearbeiten möchten.");
        } else {
            int index = _table.convertRowIndexToModel(_table.getSelectedRow());
            TournamentTableModel tournamentModel = (TournamentTableModel) _table.getModel();

            try {
                ITournamentEdit edit = factory.loadTournamentEditController();
                WettkampfDeatilAnsicht dialog = new WettkampfDeatilAnsicht(tournamentModel.getTournamentDTO(index), teamcontroller);
                dialog.setVisible(true);

            } catch (RemoteException ex) {
                Logger.getLogger(EditTournamentListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
