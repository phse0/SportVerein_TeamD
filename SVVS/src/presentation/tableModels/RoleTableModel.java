/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.IRoleDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class RoleTableModel extends DefaultTableModel {
    private List<IRoleDTO> roles;
    private String[] colNames = {"Rollenname", "Abteilung", "Sport"};

    public RoleTableModel(List<IRoleDTO> roles) {
        this.roles = roles;
    }

    @Override
    public int getRowCount() {
        return (roles == null) ? 0 : roles.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        IRoleDTO role = roles.get(row);

        switch (column) {
            case 0:
                return role.getRoleRight().getName();
            case 1:
                return role.getDepartment().getName();
            case 2:
                return role.getSport().getName();
            default:
                return null;
        }
    }

    public List<IRoleDTO> getMatches() {
        return roles;
    }

    public void setMatches(List<IRoleDTO> roles) {
        this.roles = roles;
    }
    
    public void addMatch(IRoleDTO match) {
        this.roles.add(match);
    }
    
    public void updateMatchDTO(int index, IRoleDTO match) {
        this.roles.set(index, match);
    }

    @Override
    public String getColumnName(int column) {
        return (colNames[column]);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public IRoleDTO getMatchDTO(int index) {
        return roles.get(index);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
