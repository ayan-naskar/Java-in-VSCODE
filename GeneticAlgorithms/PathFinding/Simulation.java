import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
// import java.awt.Stroke;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;
// import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.util.Arrays;
// import java.util.Collections;
import java.util.Scanner;

public class Simulation extends Frame {
    static final int width=1000, height=1000, startPosX=500, startPosY=50, endPosX=500, endPosY=950,
    flyCount=60, Iteration=150, genCount=100;
    static final double destRad=30.0, fitPercent=0.25;
    static double mutationProb=0.1;

    Environment env;

    Simulation() {
        this.setSize(width, height);
        this.setVisible(true);
        this.setBackground(new Color(200,200,160));
    }

    public void paint(Graphics gr){
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        simulate(g);
    }

    public void simulate(Graphics g) {
        
        // new Scanner(System.in).nextLine();

        //First Generation is pretty Random as basic values
        Fly f[]=new Fly[flyCount];
        for(int i=0;i<flyCount;i++) f[i]=new Fly(startPosX, startPosY, Iteration);
        env = new Environment(startPosX, startPosY, endPosX, endPosY, f);
        
        int maxfit=0, stuckCount=0;

        for(int gen=0;gen<genCount;gen++){ // Generation

            //simulating a generation
            g.setColor(new Color(200,200,160));
            g.fillRect(0, 0, Simulation.width, Simulation.height);
            for(int i=0;i<Iteration;i++){
                env.updateEnvironment(g);
                try{Thread.sleep(1);}
                catch(InterruptedException t){t.printStackTrace();}
            }

            Arrays.sort(f,(a,b)->(Environment.destinationDistance(a)-Environment.destinationDistance(b))>0?1:-1);
            System.out.println("Gen #"+gen+":");
            System.out.println("Fittest Distance = "+Environment.destinationDistance(f[0]));
            int fittestCount=(int)(fitPercent*flyCount);

            // if(maxfit<(fittestCount+70)) stuckCount++;
            // else {
            //     stuckCount=0;
            //     mutationProb=0.1;
            // }

            // if(stuckCount>=5){
            //     mutationProb+=0.25;
            // }

            maxfit=Math.max(maxfit,fittestCount);

            int cnt=0;
            Fly fnew[]=new Fly[flyCount];

            for(int i=0;i<fittestCount;i++){
                for(int j=0;j<(flyCount/fittestCount)*1.25 && cnt<flyCount;j++){
                    fnew[cnt++]=new Fly(startPosX, startPosY, Iteration, f[i], f[(int)(Math.random()*flyCount)]); // crossover constructor
                }
            }

            //need to fix this!!

            // List<Fly> list = Arrays.asList(f);
            // List<Fly> list2 = Arrays.asList(fnew);
            // System.out.println(list);
            // System.out.println(list2);
            // for(int i=0;i<flyCount;i++) 
            // list.add(list2.get(i));
            // Collections.sort(list,(a,b)->(Environment.destinationDistance(a)-Environment.destinationDistance(b))>0?1:-1);

            // Fly ff[]=new Fly[flyCount*2];
            // for(int i=0;i<flyCount*2;i++)
            // ff[i]=(i<flyCount)?f[i]:fnew[i/2];
            // Arrays.sort(ff,(a,b)->(Environment.destinationDistance(a)-Environment.destinationDistance(b))>0?1:-1);
            


            // for(int i=0;i<flyCount;i++) fnew[i]=ff[i];

            env.f = fnew;
            f = fnew;
            // mutationProb/=gen;
        }
        new Scanner(System.in).nextLine();
    }
}
