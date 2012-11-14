/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 *
 * @author Michael
 */
public class TextAreaOutputStream extends PrintStream {
    
    private JTextArea ta;
    
    public TextAreaOutputStream(JTextArea ta) {
        super(System.out);
        this.ta = ta;
    }

    @Override
    public void println(String x) {
        ta.append(x+"\n");
    }    

    @Override
    public void print(String s) {
        ta.append(s);
    }
}
