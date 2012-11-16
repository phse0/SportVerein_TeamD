/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.ITournamentInviteDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class TournamentInviteTableModel extends DefaultTableModel {

    private List<ITournamentInviteDTO> tournamentTeams;
    private String[] colNames = {"Name", "Wettkampf", "Sportart"};
    
    public TournamentInviteTableModel(List<ITournamentInviteDTO> tournamentTeams) {
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
        ITournamentInviteDTO tournamentTeam = tournamentTeams.get(row);

        switch (column) {
            case 0:
                return tournamentTeam.getTeam().getName();
            case 1:
                return tournamentTeam.getTournament().getName();
            case 2:
                return tournamentTeam.getTeam().getSport().getName();
            default:
                return null;
        }
    }

    public List<ITournamentInviteDTO> getTrainingTeams() {
        return tournamentTeams;
    }

    public void setTrainingTeams(List<ITournamentInviteDTO> tournamentTeams) {
        this.tournamentTeams = tournamentTeams;
    }

    public void addTrainingTeam(ITournamentInviteDTO tournamentTeam) {
        this.tournamentTeams.add(tournamentTeam);
    }

    public void updateTrainingTeamDTO(int index, ITournamentInviteDTO tournamentTeam) {
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

    public ITournamentInviteDTO getTrainingTeamDTO(int index) {
        return tournamentTeams.get(index);
    }
}
