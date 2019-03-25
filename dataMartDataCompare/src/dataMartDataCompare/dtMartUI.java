package dataMartDataCompare;
import javax.swing.*;

public class dtMartUI {
    public static void main(String args[]){
        JFrame frame = new JFrame("DataMart Data Validation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        
        //label.setText("Right-TOP");
        frame.setSize(900,700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        
        //JLabel label = new JLabel("Java Swing Label Demo",JLabel.TOP);
        JLabel label = new JLabel("Java Swing Label Demo");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        frame.getContentPane().add(label);
        
        panel.add(label);
         
        //frame.pack();
        frame.setVisible(true);
        
        //JLabel label1 = new JLabel("Username :", JLabel.RIGHT);
        //JLabel label2 = new JLabel("Password :", JLabel.RIGHT);
        //JLabel label3 = new JLabel("Confirm Password :", JLabel.RIGHT);
        //JLabel label4 = new JLabel("Remember Me!", JLabel.LEFT);
        //JLabel label5 = new JLabel("Hello.", JLabel.CENTER);

        //label5.setVerticalAlignment(JLabel.TOP);
        //label5.setToolTipText("A tool tip with me!");

        //frame.getContentPane().add(label1);
        //frame.getContentPane().add(label2);
        //frame.getContentPane().add(label3);
        //frame.getContentPane().add(label4);
        //frame.getContentPane().add(label5);
        
        //frame.setVisible(true);
        
     }
	
}