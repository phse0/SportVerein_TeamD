/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kno
 */
public class UserSearchPanel extends JPanel {

    JLabel _lbname;
    JLabel _lbabteilung;
    JLabel _lbbeitrag;
    JCheckBox _cbbeitrag;
    JTextField _tfname;
    JTextField _tfabteilung;
    JButton _btsuchen;
    JPanel _pinfopanel;
    JPanel _ptfpanel;

    public void init() {
        _lbname = new JLabel("Name: ");
        _lbabteilung = new JLabel("Abteilung: ");
        _lbbeitrag = new JLabel("bezahlt: ");

        _cbbeitrag = new JCheckBox();

        _tfname = new JTextField();
        _tfabteilung = new JTextField();

        _btsuchen = new JButton("Suchen");
        _btsuchen.addActionListener(new UserSearchButtonImpl(_tfname, _tfabteilung, _cbbeitrag)); 

        _pinfopanel = new JPanel();
        _ptfpanel = new JPanel();
    }

    public UserSearchPanel() {
        init();

        this.setLayout(new BorderLayout());

        _pinfopanel.setLayout(new GridLayout(3, 1));
        _ptfpanel.setLayout(new GridLayout(3, 1));

        _pinfopanel.add(_lbname);
        _pinfopanel.add(_lbabteilung);
        _pinfopanel.add(_lbbeitrag);

        _ptfpanel.add(_tfname);
        _ptfpanel.add(_tfabteilung);
        _ptfpanel.add(_cbbeitrag);

        this.add(_pinfopanel, BorderLayout.WEST);
        this.add(_ptfpanel, BorderLayout.CENTER);
        this.add(_btsuchen, BorderLayout.SOUTH);
    }
}
