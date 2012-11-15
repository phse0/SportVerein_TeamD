/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author Media Markt
 */
import business.controller.RMI.ControllerFactory;
import business.controller.RMI.IControllerFactory;
import data.DataFacade;
import data.hibernate.HibernateUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import data.interfaces.models.ISportsman;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StartPage extends JFrame {

    
    
    public StartPage() {
        initUI();


    }

    public final void initUI() {

        JMenuItem ExitMenuItem = new JMenuItem("Exit", null);
        
        ExitMenuItem.setMnemonic(KeyEvent.VK_E);
        ExitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(null);
        panel.setToolTipText("A Panel container");

        JButton quitButton = new JButton("Close Server");
        
        JTextArea ta = new JTextArea();
        
        
        panel.add(new JTextArea());
   
        PrintStream ps = new PrintStream(System.out);
        
        
        quitButton.setBounds(25, 15, 300, 30);
        
        quitButton.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent event) {
                System.exit(0);

            }
        });

        panel.add(quitButton);

        
        setTitle("RMI SERVER");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {

                    java.rmi.registry.LocateRegistry.createRegistry(1099);
                    IControllerFactory obj = new ControllerFactory();

                    System.out.println("starting server...");

                    Naming.rebind("rmi://localhost/SVVS", obj);

                    System.out.println("Factory bound in the registry");
                    StartPage ex = new StartPage();
                    ex.setVisible(true);

                } catch (RemoteException e) {
                    System.out.println("error on remote communication");
                    e.printStackTrace();
                    return;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    System.exit(1);
                    return;
                }
            }
        });
    }
}