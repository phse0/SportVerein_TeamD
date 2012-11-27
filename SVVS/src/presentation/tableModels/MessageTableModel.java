/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tableModels;

import business.messages.jms.interfaces.IMessage;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Michael
 */
public class MessageTableModel extends DefaultTableModel {

    private List<IMessage> messages;
    private String[] colNames = {"Date","Author","Text"};
   

    public MessageTableModel(List<IMessage> messages) {
        this.messages = messages;
    }

    @Override
    public int getRowCount() {
        return (messages == null) ? 0 : messages.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        IMessage message = messages.get(row);

        switch (column) {
            case 0:
                return message.getDate().toLocalDate();
            case 1:
                return message.getAuthorId();
            case 2:
                return message.getText();
            default:
                return null;
        }
    }

    public List<IMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<IMessage> messages) {
        this.messages = messages;
    }
    
    public void addMessage(IMessage message) {
        this.messages.add(message);
    }
    
    public void removeMessage(IMessage message) {
        this.messages.remove(message);
    }
    
    public void updateMessage(int index, IMessage message) {
        this.messages.set(index, message);
    }

    @Override
    public String getColumnName(int column) {
        return (colNames[column]);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public IMessage getMessage(int index) {
        return messages.get(index);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
