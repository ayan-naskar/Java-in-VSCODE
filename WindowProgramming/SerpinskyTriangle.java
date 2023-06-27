import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Stroke;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class SerpinskyTriangle extends Frame{
    class Point{
        double x,y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public SerpinskyTriangle() {
        this.setSize(1220,1000);
        this.setVisible(true);
        // this.setBackground(new Color(181,100,7));
    }

    @Override
    public void paint(Graphics gr){
        // try{Thread.sleep(5000);}
        // catch(InterruptedException e){}
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Point a=new Point(0.0,0.0),b=new Point(1000.0,0.0); 
        double len=distance(a.x,a.y,b.x,b.y), base;
        double x=(base=Math.cos(Math.toRadians(60.0))*len),y=Math.tan(Math.toRadians(60.0))*base;
        Point c=new Point(len/2.0,y);
        // drawLine(a,b,g);
        // drawLine(a,c,g);
        // drawLine(b,c,g);
        Point rand=new Point(100*Math.random(),Math.random()*100.0);
        while(true){
            printt(rand,g);
            rand = getRandomPoint(rand,a,b,c);
            try{Thread.sleep(0);}
            catch(InterruptedException e){}
        }
    }
    void drawLine(Point a, Point b,Graphics g){
        g.setColor(new Color(0,0,0));
        g.drawLine(50+(int)a.x,50+(int)a.y,50+(int)b.x,50+(int)b.y);
    }
    Point getRandomPoint(Point p, Point a, Point b, Point c){
        Point select;
        double random = Math.random();
        if(random<0.33) select = a;
        else if(random<0.66) select = b;
        else select = c;
        p.x=(p.x+select.x)/2.0;
        p.y=(p.y+select.y)/2.0;
        return p;
    }
    void printt(Point p, Graphics g){
        g.setColor(new Color(165,42,42));
        g.fillOval(50+(int)p.x,50+(int)p.y,5,5);
    }
    double distance(double x, double y, double p, double q){
        return Math.sqrt(Math.pow(p-x,2)+Math.pow(q-y,2));
    }

    public static void main(String[] args) {
        new SerpinskyTriangle();
    }
}
