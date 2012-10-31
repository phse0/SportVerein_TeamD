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

    public DeletePersonListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (JOptionPane.showConfirmDialog(new JFrame(),
                "Wollen sie die Person wirklich löschen?", "",
                JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            System.out.println("JA");
        } else {
            System.out.println("NEIN");
        }
    }
}
