/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.ITournamentTeamDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class TournamentTeamTableModel extends DefaultTableModel {

    private List<ITournamentTeamDTO> tournamentTeams;
    private String[] colNames = {"Name", "Sport", "Abteilung", "Liga"};

    public TournamentTeamTableModel(List<ITournamentTeamDTO> tournamentTeams) {
        this.tournamentTeams = tournamentTeams;
    }

    @Override
    public int getRowCount() {
        return (tournamentTeams == null) ? 0 : tournamentTeams.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        ITournamentTeamDTO tournamentTeam = tournamentTeams.get(row);

        switch (column) {
            case 0:
                return tournamentTeam.getTeamName();
            case 1:
                return tournamentTeam.getSport().getName();
            case 2:
                return tournamentTeam.getDepartment().getName();
            case 3:
                if(tournamentTeam.getLeague() != null) {
                    return tournamentTeam.getLeague().getName();
                } else {
                    return "";
                }
            default:
                return null;
        }
    }

    public List<ITournamentTeamDTO> getTournamentTeams() {
        return tournamentTeams;
    }

    public void setTournamentTeams(List<ITournamentTeamDTO> tournamentTeams) {
        this.tournamentTeams = tournamentTeams;
    }

    public void addTournamentTeam(ITournamentTeamDTO tournamentTeam) {
        this.tournamentTeams.add(tournamentTeam);
    }

    public void updateTournamentTeamDTO(int index, ITournamentTeamDTO tournamentTeam) {
        this.tournamentTeams.set(index, tournamentTeam);
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public ITournamentTeamDTO getTournamentTeamDTO(int index) {
        return tournamentTeams.get(index);
    }
}
