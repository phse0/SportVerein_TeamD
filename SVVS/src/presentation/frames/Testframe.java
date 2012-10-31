/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kno
 */
public class Testframe extends JFrame{
 public Testframe(JPanel panel)
 {
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setTitle("testframe");
     this.add(panel);
     this.pack();
     this.setVisible(true);
 }
}
