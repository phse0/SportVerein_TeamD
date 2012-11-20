/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.corba;

import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phil
 */
public class TournamentClientMatches extends JFrame {

    
    class TournamentMatchTableM extends DefaultTableModel {

        private List<TournamentClient.TempMatch> matches;
        private String[] colNames = {"Team1", "Team2", "Tore Team 1", "Tore Team 2"};

        public TournamentMatchTableM(List<TournamentClient.TempMatch> tours) {
            matches = tours;
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
            TournamentClient.TempMatch tournament = matches.get(row);

            switch (column) {
                case 0:
                    return tournament.Team1;
                case 1:
                    return tournament.Team2;
                case 2:
                    return tournament.Goals1;
                case 3:
                    return tournament.Goals2;
                default:
                    return null;
            }
        }

        public List<TournamentClient.TempMatch> getMatches() {
            return matches;
        }

        public void setMatches(List<TournamentClient.TempMatch> tournaments) {
            this.matches = tournaments;
        }

        public void addMatch(TournamentClient.TempMatch tournament) {
            this.matches.add(tournament);
        }

        public void updateMatchDTO(int index, TournamentClient.TempMatch tournament) {
            this.matches.set(index, tournament);
        }

        @Override
        public String getColumnName(int column) {
            return colNames[column];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        public TournamentClient.TempMatch getTournament(int index) {
            return matches.get(index);
        }
    }

    public TournamentClientMatches(List<TournamentClient.TempMatch> matchList) throws HeadlessException {
        initControls(matchList);
    }

    private void initControls(List<TournamentClient.TempMatch> matchList) {
        final JTable matchTable = new JTable();

        matchTable.setModel(new TournamentMatchTableM(matchList));
        this.add(matchTable);
        this.setSize(800, 250);
    }
}
