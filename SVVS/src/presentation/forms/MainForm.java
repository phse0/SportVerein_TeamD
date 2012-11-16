/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms;

import business.controller.RMI.IControllerFactory;
import business.controller.departments.IDepartmentController;
import business.controller.person.IPersonController;
import business.controller.role.EditPersonRole.IEditPersonRole;
import business.controller.role.IRoleController;
import business.controller.team.ITeamController;
import business.controller.tournament.ITournamentController;
import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.IPersonDTO;
import data.interfaces.DTOs.IRightDTO;
import data.interfaces.DTOs.IRoleDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import presentation.personListeners.CreateNewPersonListener;
import presentation.personListeners.EditPersonListener;
import presentation.personListeners.EditRolesListener;
import presentation.tableModels.PersonTableModel;
import presentation.tableModels.TournamentTableModel;
import presentation.tableModels.TrainingTeamTableModel;
import presentation.tournamentListeners.CreateNewTournamentListener;
import presentation.tournamentListeners.EditTournamentListener;
import presentation.tournamentListeners.ShowTournamentListener;
import presentation.tournamentTeamListener.EditTeamListener;

/**
 *
 * @author Michael
 */
public class MainForm extends javax.swing.JFrame {

    TableRowSorter<PersonTableModel> personSorter;
    IControllerFactory controllerFactory;
    IPersonController personController;
    IDepartmentController departmentController;
    ITournamentController tournamentController;
    ITeamController teamController;
    IRoleController roleController;
    IPersonDTO loggedUser;
    IEditPersonRole editPersonRoleController;
    List<IRoleDTO> managerRoles;
    List<IRoleDTO> coachRoles;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        try {
            loadControllers();
            initControls();
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MainForm(String user) {
        initComponents();
        try {
            loadControllers();
            loggedUser = personController.loadPersonWithUsername(user);
            checkRights();
            initControls();
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
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
        tpMain = new javax.swing.JTabbedPane();
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
        btRechte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tournamentTable = new javax.swing.JTable();
        btnCreateTournament = new javax.swing.JButton();
        btnEditTournament = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tournamentTeamTable = new javax.swing.JTable();
        btnEditTeam = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditTournamentTeam = new javax.swing.JButton();

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
        personTable.setRowHeight(26);
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
        btnEditPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPersonActionPerformed(evt);
            }
        });

        btRechte.setText("Rechteverwaltung");
        btRechte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechteActionPerformed(evt);
            }
        });

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
                        .addComponent(cobContribution, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                        .addComponent(btnFilter))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreatePerson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditPerson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRechte)
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
                    .addComponent(btRechte))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        cobContribution.getAccessibleContext().setAccessibleName("");

        tpMain.addTab("Mitglieder", jPanel1);

        tournamentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tournamentTable.setRowHeight(26);
        tournamentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tournamentTable);

        btnCreateTournament.setText("Wettkampf anlegen");

        btnEditTournament.setText("Wettkampf bearbeiten");

        jButton1.setText("Wettkampf anzeigen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCreateTournament)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditTournament)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateTournament)
                    .addComponent(btnEditTournament)
                    .addComponent(jButton1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tpMain.addTab("Wettkämpfe", jPanel2);

        tournamentTeamTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tournamentTeamTable.setRowHeight(26);
        jScrollPane2.setViewportView(tournamentTeamTable);

        btnEditTeam.setText("Team bearbeiten");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEditTeam)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditTeam)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tpMain.addTab("Teams", jPanel3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(26);
        jScrollPane4.setViewportView(jTable1);

        btnEditTournamentTeam.setText("Wettkampf Team bearbeiten");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEditTournamentTeam)
                        .addGap(0, 869, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditTournamentTeam)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpMain.addTab("Wettkampf Teams", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpMain)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpMain)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        personSorter = new TableRowSorter<>((PersonTableModel) personTable.getModel());
        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            @Override
            public boolean include(Entry<? extends Object, ? extends Object> entry) {

                String lastname = entry.getValue(0).toString().toLowerCase();
                String firstname = entry.getValue(1).toString().toLowerCase();
                String nameTxt = txtName.getText().toLowerCase();
                String abteilungen = entry.getValue(5).toString().toLowerCase();
                String contStatus;

                if (entry.getValue(8) != null) {
                    contStatus = entry.getValue(8).toString().toLowerCase();
                } else {
                    contStatus = "";
                }

                String abteilungenTxt = "";
                if (cobDepartment.getSelectedItem() instanceof IDepartmentDTO) {
                    abteilungenTxt = ((IDepartmentDTO) cobDepartment.getSelectedItem()).getName().toLowerCase();
                }

                if (nameTxt.isEmpty() && cobDepartment.getSelectedIndex() == 0 && cobContribution.getSelectedIndex() == 0) {
                    return true;
                }

                if ((lastname.contains(nameTxt) || firstname.contains(nameTxt)) && abteilungen.contains(abteilungenTxt)) {

                    if (cobContribution.getSelectedIndex() == 0) {
                        return true;
                    }

                    if (("1".equals(contStatus) && cobContribution.getSelectedIndex() == 1)
                            || ("0".equals(contStatus) && cobContribution.getSelectedIndex() == 2)) {
                        return true;
                    } else {
                        return false;
                    }

                }

                return false;
            }
        };

        personSorter.setRowFilter(filter);
        personTable.setRowSorter(personSorter);
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnEditPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditPersonActionPerformed

    private void btRechteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechteActionPerformed
    }//GEN-LAST:event_btRechteActionPerformed

    private void initControls() throws RemoteException, NotBoundException, MalformedURLException {

        this.setLocationRelativeTo(null);
        //setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH)

        // ############## INITIATE PERSONS ################

        List<IPersonDTO> personsDTO = personController.loadPersons();
        List<IDepartmentDTO> depts = departmentController.loadDepartments();

        cobDepartment.addItem("");
        for (IDepartmentDTO d : depts) {
            cobDepartment.addItem(d);
        }

        cobContribution.addItem("");
        cobContribution.addItem("Ja");
        cobContribution.addItem("Nein");

        this.personTable.setModel(new PersonTableModel(personsDTO));
        personSorter = new TableRowSorter<PersonTableModel>();
        personTable.setAutoCreateRowSorter(true);

        btnCreatePerson.addActionListener(new CreateNewPersonListener(personTable, controllerFactory));
        btnEditPerson.addActionListener(new EditPersonListener(personTable, controllerFactory));
        btRechte.addActionListener(new EditRolesListener(personTable, controllerFactory, roleController, editPersonRoleController));


        //btnDeletePerson.addActionListener(new DeletePersonListener(personTable, controllerFactory));


        // ################### INITIATE TOURNAMENTS ############################


        List<ITournamentDTO> tournamentsDTO = tournamentController.loadTournaments();
        tournamentTable.setModel(new TournamentTableModel(tournamentsDTO));
        tournamentTable.setAutoCreateRowSorter(true);

        btnCreateTournament.addActionListener(new CreateNewTournamentListener(tournamentTable, controllerFactory, managerRoles));
        btnEditTournament.addActionListener(new EditTournamentListener(tournamentTable, controllerFactory));
        jButton1.addActionListener(new ShowTournamentListener(tournamentTable, controllerFactory, teamController));

        tournamentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (managerRoles != null) {
                    TournamentTableModel model = (TournamentTableModel) tournamentTable.getModel();
                    ITournamentDTO tournament = model.getTournamentDTO(tournamentTable.getSelectedRow());

                    for (IRoleDTO r : managerRoles) {
                        try {
                            if (departmentController.isSportInDepartment(r.getDepartment(), tournament.getSport())) {
                                btnEditTournament.setEnabled(true);
                                break;
                            } else {
                                btnEditTournament.setEnabled(false);
                            }
                        } catch (RemoteException ex) {
                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });

        // ################### INITIATE TOURNAMENTTEAMS ############################

        List<ITrainingTeamDTO> tournamentTeamsDTO = teamController.loadTrainingTeams();
        tournamentTeamTable.setModel(new TrainingTeamTableModel(tournamentTeamsDTO));
        tournamentTeamTable.setAutoCreateRowSorter(true);

        btnEditTeam.addActionListener(new EditTeamListener(tournamentTeamTable, controllerFactory));

        tournamentTeamTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (coachRoles != null) {
                    TrainingTeamTableModel model = (TrainingTeamTableModel) tournamentTeamTable.getModel();
                    ITrainingTeamDTO team = model.getTrainingTeamDTO(tournamentTeamTable.getSelectedRow());

                    for (ICoachDTO coach : team.getCoaches()) {
                        for (IRoleDTO r : coachRoles) {
                            if (coach.getId() == r.getId()) {
                                btnEditTeam.setEnabled(true);
                                return;
                            }
                        }
                    }

                    btnEditTeam.setEnabled(false);

                }
            }
        });

    }

    private void loadControllers() throws RemoteException, NotBoundException, MalformedURLException {
        controllerFactory = (IControllerFactory) Naming.lookup("rmi://localhost/SVVS");
        teamController = (ITeamController) controllerFactory.loadTeamController();
        personController = (IPersonController) controllerFactory.loadPersonController();
        departmentController = (IDepartmentController) controllerFactory.loadDepartmentController();
        tournamentController = (ITournamentController) controllerFactory.loadTournamentController();
        roleController = (IRoleController) controllerFactory.loadRoleController();
        editPersonRoleController = (IEditPersonRole) controllerFactory.loadEditPersonRole();
    }

    private void checkRights() throws RemoteException {

        List<IRightDTO> rights = null;

        try {
            rights = controllerFactory.loadAuthentificationController().getAllRights();
        } catch (RemoteException e) {
            System.out.println("Couldnt connect to Authentifaction Controller");
        }

        if (loggedUser.getRight() < 1L) {
            loggedUser.setRight(1L);
        }

        List<IRightDTO> missingRights = new LinkedList<>();

        for (IRightDTO r : rights) {
            if (!loggedUser.hasRight(r.getValue())) {
                missingRights.add(r);
            } else {
                if (r.getName().equals("Wettkampf verwalten") && roleController.hasRole(loggedUser, "Manager")
                        && !roleController.hasRole(loggedUser, "Admin")) {
                    managerRoles = roleController.getRole(loggedUser, "Manager");
                }

                if (r.getName().equals("Teams verwalten") && roleController.hasRole(loggedUser, "Trainer")
                        && !roleController.hasRole(loggedUser, "Admin")) {
                    coachRoles = roleController.getRole(loggedUser, "Trainer");
                }
            }
        }

        for (IRightDTO r : missingRights) {

            if (r.getName().equals("Rechte verwalten")) {
                btRechte.setEnabled(false);
            }

            if (r.getName().equals("Teams anzeigen")) {
                tpMain.setEnabledAt(2, false);
            }

            if (r.getName().equals("Teams verwalten")) {
                btnEditTeam.setEnabled(false);
            }

            if (r.getName().equals("Wettkampf anzeigen")) {
                tpMain.setEnabledAt(1, false);
            }

            if (r.getName().equals("Wettkampf verwalten")) {
                btnCreateTournament.setEnabled(false);
                btnEditTournament.setEnabled(false);
            }

            if (r.getName().equals("Mitglied anzeigen")) {
                tpMain.setEnabledAt(0, false);
            }

            if (r.getName().equals("Mitglied verwalten")) {
                btnCreatePerson.setEnabled(false);
                btnEditPerson.setEnabled(false);
            }
        }

        for (int i = 0; i < tpMain.getTabCount(); i++) {
            if (tpMain.isEnabledAt(i)) {
                tpMain.setSelectedIndex(i);
                break;
            }
        }

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
    private javax.swing.JButton btRechte;
    private javax.swing.JButton btnCreatePerson;
    private javax.swing.JButton btnCreateTournament;
    private javax.swing.JButton btnEditPerson;
    private javax.swing.JButton btnEditTeam;
    private javax.swing.JButton btnEditTournament;
    private javax.swing.JButton btnEditTournamentTeam;
    private javax.swing.JButton btnFilter;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cobContribution;
    private javax.swing.JComboBox cobDepartment;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable personTable;
    private javax.swing.JTable tournamentTable;
    private javax.swing.JTable tournamentTeamTable;
    private javax.swing.JTabbedPane tpMain;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
