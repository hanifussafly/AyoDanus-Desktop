/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesayodanus;

import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author hanifussafly
 */
public class PengingatTask extends TimerTask {
    
    private String message;

    public PengingatTask(String message) {
        this.message = message;
    }
    
    
    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, message,"Ayo Diambil !" , JOptionPane.INFORMATION_MESSAGE);
    }
    
}
