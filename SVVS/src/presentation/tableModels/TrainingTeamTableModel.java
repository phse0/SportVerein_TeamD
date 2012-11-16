/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class TrainingTeamTableModel extends DefaultTableModel {

    private List<ITrainingTeamDTO> trainingTeams;
    private String[] colNames = {"Name", "Sport", "Abteilung", "Liga"};

    public TrainingTeamTableModel(List<ITrainingTeamDTO> tournamentTeams) {
        this.trainingTeams = tournamentTeams;
    }

    @Override
    public int getRowCount() {
        return (trainingTeams == null) ? 0 : trainingTeams.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        ITrainingTeamDTO tournamentTeam = trainingTeams.get(row);

        switch (column) {
            case 0:
                return tournamentTeam.getName();
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

    public List<ITrainingTeamDTO> getTrainingTeams() {
        return trainingTeams;
    }

    public void setTrainingTeams(List<ITrainingTeamDTO> tournamentTeams) {
        this.trainingTeams = tournamentTeams;
    }

    public void addTrainingTeam(ITrainingTeamDTO tournamentTeam) {
        this.trainingTeams.add(tournamentTeam);
    }

    public void updateTrainingTeamDTO(int index, ITrainingTeamDTO tournamentTeam) {
        this.trainingTeams.set(index, tournamentTeam);
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public ITrainingTeamDTO getTrainingTeamDTO(int index) {
        return trainingTeams.get(index);
    }
}
