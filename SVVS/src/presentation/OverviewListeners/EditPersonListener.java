/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.OverviewListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Kno
 */
public class EditPersonListener implements ActionListener {

    JTable _table;

    public EditPersonListener(JTable table) {
        _table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie bearbeiten möchten.");
        } else {
            System.out.println(_table.getSelectedRow() + " wird bearbeitet!!");
        }
    }
}
