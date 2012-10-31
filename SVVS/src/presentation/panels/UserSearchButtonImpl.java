/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author Kno
 */
public class UserSearchButtonImpl implements ActionListener {

    JCheckBox _cbbeitrag;
    JTextField _tfname;
    JTextField _tfabteilung;

    UserSearchButtonImpl(JTextField name, JTextField abteilung, JCheckBox beitrag) {
        _cbbeitrag = beitrag;
        _tfname = name;
        _tfabteilung = abteilung;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("BUTTONCLICKEsD!");
        System.out.println("Name: " + _tfname.getText() + " || Beitrag: " + _tfabteilung.getText());
        if(_cbbeitrag.isSelected())
            System.out.println("JA");
        else
            System.out.println("NEIN");
    }
}
