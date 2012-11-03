/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.matchListeners;

import business.controller.tournament.edit.ITournamentEdit;
import data.interfaces.DTOs.ITournamentDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import presentation.forms.CreateMatchDialog;
import presentation.tableModels.MatchTableModel;

/**
 *
 * @author Michael
 */
public class CreateNewMatchListener implements ActionListener {

    private ITournamentEdit editController;
    private ITournamentDTO tournament;
    private JTable matches;

    public CreateNewMatchListener(JTable matchTable, ITournamentEdit editController, ITournamentDTO tournament) {
        this.editController = editController;
        this.tournament = tournament;
        this.matches = matchTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateMatchDialog dialog = new CreateMatchDialog(null, true, editController, tournament);
        dialog.setVisible(true);
        
        if(dialog.getMatch() != null) {
            MatchTableModel model = (MatchTableModel) matches.getModel();
            model.addMatch(dialog.getMatch());
            model.fireTableDataChanged();
        }
    }
}
