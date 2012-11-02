/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import business.controller.person.IPersonController;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.IPersonDTO;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class PersonTableModel extends DefaultTableModel {

    private List<IPersonDTO> persons;
    private IPersonController controller;
    private String[] colNames = {"Nachname", "Vorname", "Geburtstag", "Telefon", "Mail", "Abteilung", "Hauptadresse"};

    public PersonTableModel(List<IPersonDTO> persons, IPersonController controller) {
        this.persons = persons;
        this.controller = controller;
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
                String departments = "";
                for (int i = 0; i < person.getDepartments().size(); i++) {
                    IDepartmentDTO d = person.getDepartments().get(i);

                    if (!departments.contains(d.getName())) {
                        departments += d.getName() + ", ";
                    }
                }
                if (!"".equals(departments)) {
                    departments = departments.substring(0, departments.length() - 2);
                }
                return departments;
            case 6:
                return person.getMainAddress().toString();
            case 7:
                return person.getId();
            case 8:
                return person.getContributionStatus();
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

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public IPersonDTO getPersonDTO(int index) {
        return persons.get(index);
    }

    @Override
    public void fireTableDataChanged() {
        try {
            this.persons = controller.loadPersons();
        } catch (RemoteException ex) {
            Logger.getLogger(PersonTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
