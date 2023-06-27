import java.awt.*;
import java.awt.event.*;

public class window2 extends Frame implements ActionListener {
    TextField t1;
    Label l1;
    Button b1;

    public window2()
    {
        t1=new TextField();
        l1=new Label("");
        b1=new Button("Click Me!");
        this.setSize(400,400);
        t1.setBounds(100,100,100,30);
        b1.setBounds(100,200,100,30);
        l1.setBounds(100,300,100,30);
        b1.addActionListener(this);

        this.add(t1);
        this.add(b1);
        this.add(l1);

        this.setLayout(null);
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
        new window2();
    }
}
