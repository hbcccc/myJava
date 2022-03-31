package C6.InterfacePrac;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.event.*;
import java.time.Instant;

public class callBack {
    public static void main(String[] args) {
        TimePrinter tp = new TimePrinter();
        Timer timer = new Timer(1000, tp);
        timer.start();
        JOptionPane.showMessageDialog(null, "quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("the time is: "+Instant.ofEpochMilli( e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
        
    } 
    
}


