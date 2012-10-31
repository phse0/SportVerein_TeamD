/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kno
 */
public class UserShowPanel extends JPanel {

    private JTable _table;
    private String[] _columnnames;
    private JPanel _pbotpanel;
    private JButton _btbearbeiten;
    private JButton _btloeschen;

    public void init() {

        String[] columnnames = {"Name", "Addresse", "Abteilung"};
        _columnnames = columnnames;

        Object[][] data = {
            {"Kathy", "Smith", "Snowboarding"},
            {"John", "Doe", "Rowing"},
            {"Sue", "Black", "Knitting"},
            {"Jane", "White", "Speed reading"},
            {"Joe", "Brown", "Pool"}
        };
        _table = new JTable(data, _columnnames);
        _table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        _table.setFillsViewportHeight(true);

        DefaultTableModel dtm = new DefaultTableModel(data, _columnnames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        _table.setModel(dtm);

        _pbotpanel = new JPanel();
        _btbearbeiten = new JButton("Bearbeiten");
        _btloeschen = new JButton("Löschen");
        _pbotpanel.setLayout(new FlowLayout());
        _pbotpanel.add(_btbearbeiten);
        _pbotpanel.add(_btloeschen);
    }

    public UserShowPanel() {
        init();
        JScrollPane scrollPane = new JScrollPane(_table);
        this.add(scrollPane);
        this.add(_pbotpanel);
    }
}
