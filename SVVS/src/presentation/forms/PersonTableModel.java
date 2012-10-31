/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms;

import data.interfaces.DTOs.IPersonDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Michael
 */
public class PersonTableModel extends AbstractTableModel {

    private List<IPersonDTO> persons;
    private String[] colNames = {"Nachname", "Vorname", "Geburtstag", "Telefon", "Mail", "Abteilung", "Hauptadresse"};

    public PersonTableModel(List<IPersonDTO> persons) {
        this.persons = persons;
    }

    @Override
    public int getRowCount() {
        return (persons == null) ? 0 : persons.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IPersonDTO person = persons.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return person.getLastname();
            case 1:
                return person.getFirstname();
            case 2:
                return person.getBirthdate();
            case 3:
                return person.getPhone();
            case 4:
                return person.getMail();
            case 5:
                return "";
            case 6:
                return person.getMainAddress().toString();
            case 7:
                return person.getId();
            default:
                return null;
        }
    }

    public List<IPersonDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<IPersonDTO> persons) {
        this.persons = persons;
    }

    @Override
    public String getColumnName(int column) {
        return (colNames[column]);
    }
}
