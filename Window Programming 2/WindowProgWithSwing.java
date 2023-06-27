import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowProgWithSwing extends JFrame implements ActionListener {
    JTextField t1;
    JLabel l1;
    JButton b1;

    public WindowProgWithSwing()
    {
        t1=new JTextField();
        l1=new JLabel("");
        b1=new JButton("Click Me!");
        this.setSize(400,400);
        t1.setBounds(100,100,100,30);
        b1.setBounds(100,200,100,30);
        l1.setBounds(100,300,100,30);
        b1.addActionListener(this);

        this.add(t1);
        this.add(b1);
        this.add(l1);

        this.setLayout(null);
        this.getContentPane().setBackground(Color.YELLOW);;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        try {
            String txt=t1.getText();
            l1.setText("Hello "+txt+"!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new WindowProgWithSwing();
    }
}
