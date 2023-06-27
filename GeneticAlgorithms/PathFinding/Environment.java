import java.awt.*;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Environment {
    int startPosX, startPosY, endPosX, endPosY;
    Fly f[];

    Obstacle o[];

    public static Image image;

    public Environment(int startPosX, int startPosY, int endPosX, int endPosY, Fly f[]) {
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.endPosX = endPosX;
        this.endPosY = endPosY;
        this.f=f;

        o=new Obstacle[4]; // Obstacle formation
        o[0] = new Obstacle(400, 100, 600, 150);
        o[1] = new Obstacle(575, 150, 600, 800);
        o[2] = new Obstacle(400, 0, 450, 150);
        o[3] = new Obstacle(800, 0, 825, 1000);
        // o[0] = new Obstacle(400, 100, 660, 150);
        // o[1] = new Obstacle(640, 150, 660, 800);
        // o[2] = new Obstacle(400, 0, 450, 150);
        // o[3] = new Obstacle(900, 0, 925, 1000);

        ImageIcon img = new ImageIcon("ant.png");
        image=img.getImage();
    }
    
    public void updateEnvironment(Graphics g) {
        // g.setColor(new Color(160,160,160));
        // g.fillRect(0, 0, Simulation.width, Simulation.height);
        int val=0;

        for(Fly fly: f) val+=updateFly(fly, g);        

        g.setColor(new Color(0,0,0));
        g.fillOval(startPosX, startPosY, (int)Simulation.destRad, (int)Simulation.destRad);
        for(Fly fly: f) {            
            g.drawImage(image, (int)fly.posX, (int)fly.posY, 10, 10, null, null);
        }
        g.fillOval(endPosX, endPosY, (int)Simulation.destRad, (int)Simulation.destRad);
        if(val>0) {
            System.out.println("Path Found!! Do you want to continue?");
            new Scanner(System.in).nextLine();
            val=0;
        }
    }

    private int updateFly(Fly f, Graphics g) {
        double dist=destinationDistance(f);

        if(f.posX<0 || f.posX>=Simulation.width || f.posY<0 || f.posY>Simulation.height) return 0;
        if(dist<Simulation.destRad) return 1;
        for(Obstacle ob: o) {
            if(f.posX>=ob.x1 && f.posX<=ob.x2 && f.posY>=ob.y1 && f.posY<=ob.y2) return 0;
            g.setColor(new Color(0,0,0));
            g.fillRect(ob.x1, ob.y1, ob.x2-ob.x1, ob.y2-ob.y1);
        }
        // System.out.println("Here");
        f.velX += f.dna[f.currIteration].accX;
        f.velY += f.dna[f.currIteration].accY;

        f.posX += f.velX;
        f.posY += f.velY;

        f.currIteration++;
        return 0;
    }

    public static double destinationDistance(Fly f) {
        double diffx=f.posX-Simulation.endPosX, diffy=f.posY-Simulation.endPosY;
        return Math.sqrt(diffx*diffx+diffy*diffy);
    }
}
