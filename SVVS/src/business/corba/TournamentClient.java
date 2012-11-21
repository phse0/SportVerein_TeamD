/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.corba;

import CorbaTournament.Tournament.TounamentControll;
import CorbaTournament.Tournament.TounamentControllHelper;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author phil
 */
public class TournamentClient extends JFrame {

    //only for internal use
    static class TempTour {

        int id;
        String Name;
        String Location;
        String Date;
    }

    static class TempMatch {

        String Team1;
        String Team2;
        int Goals1;
        int Goals2;
    }

    private static List<TempTour> createTours(String tournaments) {
        List<TempTour> tours = new LinkedList<>();
        TempTour tt = new TempTour();
        String temp = "";
        for (int i = 0; i < tournaments.length(); i++) {

            if (tournaments.toCharArray()[i] != '\n') {
                temp += tournaments.toCharArray()[i];
            } else {
                String[] data = temp.split(";");
                tt.id = Integer.parseInt(data[0]);
                tt.Name = data[1];
                tt.Location = data[2];
                tt.Date = data[3];

                tours.add(tt);
                tt = new TempTour();
                temp = "";
            }
        }
        return tours;
    }

    private static List<TempMatch> createMatchs(String matches) {
        List<TempMatch> matchList = new LinkedList<>();
        TempMatch tm = new TempMatch();
        String temp = "";
        for (int i = 0; i < matches.length(); i++) {

            if (matches.toCharArray()[i] != '\n') {
                temp += matches.toCharArray()[i];
            } else {
                //if (!temp.equals("false")) {
                String[] data = temp.split(";");
                tm.Team1 = data[0];
                tm.Team2 = data[1];
                tm.Goals1 = Integer.parseInt(data[2]);
                tm.Goals2 = Integer.parseInt(data[3]);

                matchList.add(tm);
                tm = new TempMatch();
                temp = "";
                /*} else {
                 JOptionPane.showMessageDialog(null, "Not finished!", "Not finished!", JOptionPane.OK_OPTION);
                 break;
                 }*/
            }
        }
        return matchList;
    }

    class TournamentTableM extends DefaultTableModel {

        private List<TempTour> tournaments;
        private String[] colNames = {"Name", "Ort", "Datum"};

        public TournamentTableM(List<TempTour> tours) {
            tournaments = tours;
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
            TempTour tournament = tournaments.get(row);

            switch (column) {
                case 0:
                    return tournament.Name;
                case 1:
                    return tournament.Location;
                case 2:
                    return tournament.Date;
                default:
                    return null;
            }
        }

        public List<TempTour> getTournaments() {
            return tournaments;
        }

        public void setTournaments(List<TempTour> tournaments) {
            this.tournaments = tournaments;
        }

        public void addTournament(TempTour tournament) {
            this.tournaments.add(tournament);
        }

        public void updateTournamentDTO(int index, TempTour tournament) {
            this.tournaments.set(index, tournament);
        }

        @Override
        public String getColumnName(int column) {
            return colNames[column];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        public TempTour getTournament(int index) {
            return tournaments.get(index);
        }
    }

    public static void main(String[] args) {// create and initialize the ORB
        ORB orb = ORB.init(args, null);
        // get the root naming context
        org.omg.CORBA.Object objRef;
        try {
            objRef = orb.resolve_initial_references("NameService");
        } catch (InvalidName e) {
            System.out.println("Couldn't find NameService within the ORB.");
            e.printStackTrace();

            return;
        }

        // Use NamingContextExt instead of NamingContext. This is part of the
        // Interoperable naming Service
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        try {
            TounamentControll tournamentstub = TounamentControllHelper.narrow(
                    ncRef.resolve_str("TournamentObject"));
            new TournamentClient(tournamentstub).setVisible(true);

        } catch (Exception e) {
            System.out.println("Error on getting the data:");
            e.printStackTrace();
        }

    }

    public TournamentClient(TounamentControll tournamentstub) throws HeadlessException {
        initControls(tournamentstub);
    }

    private void initControls(final TounamentControll tournamentstub) {
        JPanel panel = new JPanel();
        BoxLayout bl = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(bl);
        JButton tourBut = new JButton();
        tourBut.setText("Zeige Wettkampf");

        final JTable tourTable = new JTable();

        tourBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tourTable.getSelectedRow() != -1) {
                    int index = tourTable.convertRowIndexToModel(tourTable.getSelectedRow());
                    TournamentTableM ttm = (TournamentTableM) tourTable.getModel();
                    if (!tournamentstub.isFinished(ttm.getTournament(index).id)) {
                        JOptionPane.showMessageDialog(null, "Dieser Wettkampf ist noch nicht beendet!", "Achtung", JOptionPane.OK_OPTION);
                    }
                    List<TempMatch> matchList = createMatchs(tournamentstub.loadTournament(ttm.getTournament(index).id));
                    if (matchList.size() > 0) {
                        new TournamentClientMatches(matchList).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst einen Wettkampf auswählen!", "Meldung", JOptionPane.OK_OPTION);
                }

            }
        });
        tourTable.setModel(new TournamentTableM(createTours(tournamentstub.loadTournaments())));
        panel.add(tourTable);
        panel.add(tourBut);
        this.add(panel);
        this.setSize(800, 250);
        this.setResizable(false);
        this.setTitle("Wettkampfanzeige");
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}