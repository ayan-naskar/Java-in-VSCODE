import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
public class window3 extends Frame{
    int x,y;
    static int count;
    public static void main(String[] args) {
        count=0;
        new window3();
    }
    public window3(){
        this.setSize(x=1000,y=800);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        count++;
        int size;
        while(true){
            g.setColor(new Color(random()%255,random()%255,random()%255));
            g.fillOval(random()%x,random()%y,size=random()%100,size);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            // g.setColor(new Color(255,255,255));
            // g.fillRect(0,0,1000,800);
            if(true)break;
        }
        System.out.println(count);
    }  
    int random(){
        return (int)(Math.random()*1000);
    }
}
