/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author Media Markt
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CreatePersonPage extends JFrame{


    public CreatePersonPage() {
         initUI();
     }
    public final void initUI() {

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

       panel.add(quitButton);
     panel.add(createPersonButton);
     panel.add(changePersonButton);

        setTitle("Welcome Create Person Page!");
       setSize(800, 600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
       //         StartPage ex = new StartPage();
         //       ex.setVisible(true);
                new StartPage().setVisible(true);
            }
        });
    }
}    
