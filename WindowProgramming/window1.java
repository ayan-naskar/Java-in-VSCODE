import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;

public class window1 extends Frame{
    int x,y;
    public window1()
    {
        x=y=0;
        this.setSize(400,400);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        
        g.drawString("Hello World", 100, 100);
        g.setColor(new Color(150,150,150));
        g.fillRect(150+x, 150+y, 200, 100);
        g.setColor(new Color(255,0,0));
        g.drawOval(50, 50, 300, 250);
        try{
        while(x<10000 && y<10000)
            repaint();
            Thread.sleep(1000);
        }catch(InterruptedException e){}

    }

    public void repaint()
    {
        x+=10;
        y+=10;
    }
    public static void main(String args[])
    {
        new window1();
    }
}