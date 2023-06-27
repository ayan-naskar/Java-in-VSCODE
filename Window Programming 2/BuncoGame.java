import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class BuncoGame extends JFrame implements ActionListener {
    JLabel Ldice1,Ldice2,Ldice3;
    JButton rollBtn;
    DiceCup dc;

    public BuncoGame(){
        dc = new DiceCup();
        Ldice1 = new JLabel("-");
        Ldice2 = new JLabel("-");
        Ldice3 = new JLabel("-");
        Ldice1.setFont(new Font("Arial", Font.BOLD, 50));
        Ldice2.setFont(new Font("Arial", Font.BOLD, 50));
        Ldice3.setFont(new Font("Arial", Font.BOLD, 50));

        rollBtn = new JButton("Shake the Cup");
        
        this.setSize(300,500);

        Ldice1.setBounds(25,100,50,40);
        Ldice2.setBounds(125,100,50,40);
        Ldice3.setBounds(225,100,50,40);
        
        rollBtn.setBounds(75,200,150,50);
        rollBtn.setFocusPainted(false);

        rollBtn.addActionListener(this);

        this.add(Ldice1);
        this.add(Ldice2);
        this.add(Ldice3);
        this.add(rollBtn);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            dc.roll();
            Ldice1.setText(""+dc.getDice1());
            Ldice2.setText(""+dc.getDice2());
            Ldice3.setText(""+dc.getDice3());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new BuncoGame();
    }
}
