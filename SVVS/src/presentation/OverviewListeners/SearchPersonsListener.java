/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.OverviewListeners;

import data.interfaces.DTOs.IPersonDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import presentation.HubertTests.PersonTableModel;

/**
 *
 * @author Kno
 */
public class SearchPersonsListener implements ActionListener {

    private JCheckBox _cbbeitrag;
    private JTextField _tfname;
    private JTextField _tfabteilung;
    private JTable _table;

    public SearchPersonsListener(JTextField name, JTextField abteilung, JCheckBox beitrag, JTable table) {
        _cbbeitrag = beitrag;
        _tfname = name;
        _tfabteilung = abteilung;
        _table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //LÖSCHEN AB HIER -> falls untere funktion fertig ist!
        //die werte werden nun weitergegeben!
        System.out.println("Name: " + _tfname.getText() + " || Beitrag: " + _tfabteilung.getText() + "|| Beitrag gezahlt: " + _cbbeitrag.isSelected());

        //und dtos kommen dann rein
        PersonTableModel temp = (PersonTableModel) _table.getModel();
        temp.persons.remove(1);
        List<IPersonDTO> dtos = temp.persons;

        //LÖSCHEN ENDE HIER
        
        //  List<IPersonDTO> dtos = NÄCHSTESCHICHT.SUCHE(name, beitrag, gezahlt);

        _table.setModel(new PersonTableModel(dtos));
    }
}