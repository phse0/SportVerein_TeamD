/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author Media Markt
 */
import data.DAOs.CountryDAO;
import data.DAOs.SportsmanDAO;
import data.DataFacade;
import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.ICountryDAO;
import data.interfaces.DAOs.ISportsmanDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import data.interfaces.models.ICountry;
import data.interfaces.models.ISportsman;
import java.util.List;


import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StartPage extends JFrame {
    


    public StartPage() {
         initUI();
   

     }
    public final void initUI() {

 
              Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();
//        ISportsmanDAO sportsmanDAO = DataFacade.getSportsmanDAO();
  //    List<ISportsman> sportsmen = sportsmanDAO.getAll(s);
        
        ISportsman sm = DataFacade.getSportsmanDAO().getAll(s).get(1);
       
     
       JMenuBar menubar = new JMenuBar();
 
        JMenu Person = new JMenu("Person");
        Person.setMnemonic(KeyEvent.VK_P);
        JMenu Team = new JMenu("Team");
        Person.setMnemonic(KeyEvent.VK_T);

        JMenuItem ExitMenuItem = new JMenuItem("Exit", null);
      JMenuItem CreatePersonMenuItem = new JMenuItem("Create Person = "+sm.getPersonName(), null);
   //         JMenuItem CreatePersonMenuItem = new JMenuItem("Create Person = "+"bbb", null);
        ExitMenuItem.setMnemonic(KeyEvent.VK_E);
        CreatePersonMenuItem.setMnemonic(KeyEvent.VK_C);
        CreatePersonMenuItem.setToolTipText("Create Person");
        ExitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });

       Person.add(CreatePersonMenuItem);
       Person.add(ExitMenuItem);
 
       menubar.add(Person);

    //    JMenuItem ExitMenuItem = new JMenuItem("Exit", null);
        JMenuItem CreateTeamMenuItem = new JMenuItem("Create Team", null);
       JMenuItem ChangeTeamMenuItem = new JMenuItem("Change Team", null);
     //   ExitMenuItem.setMnemonic(KeyEvent.VK_E);
        CreateTeamMenuItem.setMnemonic(KeyEvent.VK_C);
        ChangeTeamMenuItem.setToolTipText("Create Person");
   
       Team.add(CreateTeamMenuItem);
       Team.add(ChangeTeamMenuItem);
 
       menubar.add(Team);

       setJMenuBar(menubar);

   
       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);
       panel.setToolTipText("A Panel container");

       JButton quitButton = new JButton("Quit");
       JButton createPersonButton = new JButton("Create Person");
       JButton changePersonButton = new JButton("Change Person");
        quitButton.setBounds(50, 460, 80, 30);
      createPersonButton.setBounds(50, 60, 180, 30);
      changePersonButton.setBounds(50, 160, 180, 30);
      changePersonButton.setToolTipText("A change Person Button");
      quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
   
          }
       });
      createPersonButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
             System.exit(0);
     //CreatePersonPage();
          }
       });

       panel.add(quitButton);
     panel.add(createPersonButton);
     panel.add(changePersonButton);

        setTitle("Welcome to our SportVerein Start Page!");
       setSize(800, 600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StartPage ex = new StartPage();
                ex.setVisible(true);
            }
        });
    }
}