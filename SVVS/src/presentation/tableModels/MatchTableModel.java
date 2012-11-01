/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.IMatchDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class MatchTableModel extends DefaultTableModel {

    private List<IMatchDTO> matches;
    private String[] colNames = {"Team 1", "Team 2", "Datum", "Ort", "Result"};

    public MatchTableModel(List<IMatchDTO> matches) {
        this.matches = matches;
    }

    @Override
    public int getRowCount() {
        return (matches == null) ? 0 : matches.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        IMatchDTO match = matches.get(row);

        switch (column) {
            case 0:
                return match.getTeam1().getName();
            case 1:
                return match.getTeam2().getName();
            case 2:
                return match.getDate();
            case 3:
                return match.getLocation();
            case 4:
                return match.getGoalsTeam1() + " : " + match.getGoalsTeam2();
            default:
                return null;
        }
    }

    public List<IMatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<IMatchDTO> matches) {
        this.matches = matches;
    }

    @Override
    public String getColumnName(int column) {
        return (colNames[column]);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public IMatchDTO getMatchDTO(int index) {
        return matches.get(index);
    }
}
