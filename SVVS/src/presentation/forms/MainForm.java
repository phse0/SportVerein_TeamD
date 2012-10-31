/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms;

import data.DAOs.DepartmentDAO;
import data.DAOs.PersonDAO;
import data.DTOs.PersonDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.models.IDepartment;
import data.interfaces.models.IPerson;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.table.TableRowSorter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import presentation.OverviewListeners.CreateNewPersonListener;
import presentation.OverviewListeners.DeletePersonListener;
import presentation.OverviewListeners.EditPersonListener;

/**
 *
 * @author Michael
 */
public class MainForm extends javax.swing.JFrame {

    TableRowSorter<PersonTableModel> sorter;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        initControls();
        
        this.setLocationRelativeTo(null);
        //setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cobDepartment = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cobContribution = new javax.swing.JComboBox();
        btnFilter = new javax.swing.JButton();
        btnCreatePerson = new javax.swing.JButton();
        btnEditPerson = new javax.swing.JButton();
        btnDeletePerson = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sportverein-Verwaltungssystem");
        setResizable(false);

        personTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        personTable.setRowHeight(24);
        personTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(personTable);
        personTable.getAccessibleContext().setAccessibleName("tblMembers");

        jLabel1.setText("Name");

        jLabel3.setText("Abteilung");

        jLabel4.setText("Mitgliedsbeitrag gezahlt");

        btnFilter.setText("Filtern");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnCreatePerson.setText("Mitglied anlegen");
        btnCreatePerson.setActionCommand("");

        btnEditPerson.setText("Mitglied bearbeiten");
        btnEditPerson.setActionCommand("");

        btnDeletePerson.setText("Mitglied löschen");
        btnDeletePerson.setActionCommand("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cobDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cobContribution, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                        .addComponent(btnFilter))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreatePerson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditPerson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePerson)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cobDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cobContribution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreatePerson)
                    .addComponent(btnEditPerson)
                    .addComponent(btnDeletePerson))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        cobContribution.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Mitglieder", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1058, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Wettkämpfe", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        sorter = new TableRowSorter<>((PersonTableModel) personTable.getModel());
        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            @Override
            public boolean include(Entry<? extends Object, ? extends Object> entry) {

                String lastname = entry.getValue(0).toString().toLowerCase();
                String firstname = entry.getValue(1).toString().toLowerCase();
                String nameTxt = txtName.getText();
                String abteilungen = entry.getValue(5).toString().toLowerCase();
                String abteilungenTxt = cobDepartment.getSelectedItem().toString();

                if (nameTxt.isEmpty() && cobDepartment.getSelectedIndex() == 0) {
                    return true;
                }

                if ((lastname.contains(nameTxt) || firstname.contains(nameTxt)) && abteilungen.contains(abteilungenTxt)) {
                    return true;
                }

                return false;
            }
        };

        sorter.setRowFilter(filter);
        personTable.setRowSorter(sorter);
    }//GEN-LAST:event_btnFilterActionPerformed

    private void initControls() {

        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();

        PersonDAO persondao = (PersonDAO) PersonDAO.getInstance();
        List<IPerson> persons = persondao.getAll(s);
        List<IPersonDTO> personsDTO = new LinkedList<>();

        for (IPerson p : persons) {
            personsDTO.add(new PersonDTO(p));
        }

        DepartmentDAO deptdao = (DepartmentDAO) DepartmentDAO.getInstance();
        List<IDepartment> depts = deptdao.getAll(s);

        cobDepartment.addItem("");
        for (IDepartment d : depts) {
            cobDepartment.addItem(d.getName());
        }

        cobContribution.addItem("");
        cobContribution.addItem("Ja");
        cobContribution.addItem("Nein");

        this.personTable.setModel(new PersonTableModel(personsDTO));
        sorter = new TableRowSorter<PersonTableModel>();
        personTable.setAutoCreateRowSorter(true);
        
        btnCreatePerson.addActionListener(new CreateNewPersonListener());
        btnEditPerson.addActionListener(new EditPersonListener(personTable));
        btnDeletePerson.addActionListener(new DeletePersonListener(personTable));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        new MainForm().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePerson;
    private javax.swing.JButton btnDeletePerson;
    private javax.swing.JButton btnEditPerson;
    private javax.swing.JButton btnFilter;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cobContribution;
    private javax.swing.JComboBox cobDepartment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable personTable;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
