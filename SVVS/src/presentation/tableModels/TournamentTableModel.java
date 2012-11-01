/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.ITournamentDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class TournamentTableModel extends DefaultTableModel {

    private List<ITournamentDTO> tournaments;
    private String[] colNames = {"Name", "Ort", "Datum", "Gebühr"};

    public TournamentTableModel(List<ITournamentDTO> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public int getRowCount() {
        return (tournaments == null) ? 0 : tournaments.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        ITournamentDTO tournament = tournaments.get(row);
        
        switch(column) {
            case 0:
                return tournament.getName();
            case 1:
                return tournament.getLocation();
            case 2:
                return tournament.getDate();
            case 3:
                return tournament.getFee();
            default:
                return null;
        }
    }

    public List<ITournamentDTO> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<ITournamentDTO> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    public ITournamentDTO getTournamentDTO(int index) {
        return tournaments.get(index);
    }
    
}
