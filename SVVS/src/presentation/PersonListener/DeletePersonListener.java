/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.PersonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * DeletePersonListener benötigt die JTable damit er den aktuellen Datensatz
 * löschen kann!
 *
 * @author Kno
 */
public class DeletePersonListener implements ActionListener {

    JTable _table;

    public DeletePersonListener(JTable table) {
        _table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (_table.getSelectedRow() != -1) {
            if (JOptionPane.showConfirmDialog(null,
                    "Wollen sie die Person wirklich löschen?", "",
                    JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                //LÖSCHEN
                System.out.println(_table.getSelectedRow() + " wird gelöscht!!!");
            } else {
                //will doch nicht löschen!
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie löschen möchten.");
        }
    }
}
