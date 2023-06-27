// import java.awt.Graphics;
// import java.awt.Color;
// import java.awt.Frame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class actionList extends Frame implements ActionListener, MouseListener{
    Image image; 
    int x, y; 
    Timer time;
    int dx,dy;
    int imagew,imageh;
    Label l1;

    final int initialx = 100, initialy = 100,
              height = 500, width = 1000;

    actionList() {
        ImageIcon img = new ImageIcon("ball.png");
        image=img.getImage();
        l1 = new Label("Hello World!");
        l1.setBounds(495,900,30,100);
        
        Timer time = new Timer(5,this);
        x = initialx; y = initialy;
        this.setLayout(null);
        this.add(l1);
        this.setBackground(new Color(0,154,0));
        
        this.setSize(width,height);
        this.setVisible(true);
        dx=7;dy=7;
        imagew=imageh=50;

        
        time.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
        actionList lst=new actionList();
        lst.setVisible(true);
        });
    }    

    @Override
    public void paint(Graphics g){
        g.drawImage(image,x,y,imagew,imageh,this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        x+=dx; y+=dy;
        if((x+imagew)>=width) dx*=-1;
        if((y+imageh)>=height) dy*=-1;
        if(x<=0)dx*=-1;
        if(y<=imageh/2)dy*=-1;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e){
        int x=e.getX(), y=e.getY();
        l1.setText("("+x+","+y+")");
    }



    @Override
    public synchronized void addMouseListener(MouseListener l) {
        // TODO Auto-generated method stub
        super.addMouseListener(l);
    }



    @Override
    public boolean mouseEnter(Event evt, int x, int y) {
        // TODO Auto-generated method stub
        return super.mouseEnter(evt, x, y);
    }



    @Override
    public boolean mouseExit(Event evt, int x, int y) {
        // TODO Auto-generated method stub
        return super.mouseExit(evt, x, y);
    }



    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}