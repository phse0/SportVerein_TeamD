/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.ISportsmanDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class SportsManTableModel extends DefaultTableModel {

    private List<ISportsmanDTO> sportsmen;
    private String[] colNames = {"Nachname", "Vorname", "Position"};

    public SportsManTableModel(List<ISportsmanDTO> sportsmen) {
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
        ISportsmanDTO sportsman = sportsmen.get(rowIndex);

            return null;
    }

    public List<ISportsmanDTO> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<ISportsmanDTO> sportsmen) {
        this.sportsmen = sportsmen;
    }

    public void addSportsman(ISportsmanDTO sportsman) {
        this.sportsmen.add(sportsman);
    }

    @Override
    public String getColumnName(int column) {
        return (colNames[column]);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public ISportsmanDTO getSportsmanDTO(int index) {
        return sportsmen.get(index);
    }

    public void updateSportsmanDTO(int index, ISportsmanDTO sportsman) {
        sportsmen.set(index, sportsman);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
