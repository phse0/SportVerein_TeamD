/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class SportsManTableModel extends DefaultTableModel {

    private List<ISportsmanTrainingTeamDTO> sportsmen;
    private String[] colNames = {"Nachname", "Vorname", "Position"};

    public SportsManTableModel(List<ISportsmanTrainingTeamDTO> sportsmen) {
        this.sportsmen = sportsmen;
    }

    @Override
    public int getRowCount() {
        return (sportsmen == null) ? 0 : sportsmen.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ISportsmanTrainingTeamDTO sportsman = sportsmen.get(rowIndex);

        switch(columnIndex) {
            case 0:
                return sportsman.getSportsman().getPerson().getLastname();
            case 1:
                return sportsman.getSportsman().getPerson().getFirstname();
            case 2:
                return sportsman.getPosition();
            default:
                return null;
        }
    }

    public List<ISportsmanTrainingTeamDTO> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<ISportsmanTrainingTeamDTO> sportsmen) {
        this.sportsmen = sportsmen;
    }

    public void addSportsman(ISportsmanTrainingTeamDTO sportsman) {
        this.sportsmen.add(sportsman);
    }
    
    public void removeSportsman(ISportsmanTrainingTeamDTO sportsman) {
        this.sportsmen.remove(sportsman);
    }

    @Override
    public String getColumnName(int column) {
        return (colNames[column]);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public ISportsmanTrainingTeamDTO getSportsmanDTO(int index) {
        return sportsmen.get(index);
    }

    public void updateSportsmanDTO(int index, ISportsmanTrainingTeamDTO sportsman) {
        sportsmen.set(index, sportsman);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
