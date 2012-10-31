/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Michael
 */
public class PersonTableModel extends AbstractTableModel {
    
    
    private List<Object> persons;
    private String[] colNames = {"Nachname", "Vorname", "Geburtstag", "Telefon", "Mail", "Abteilung", "Hauptadresse"};
    
    public PersonTableModel() {
        
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
