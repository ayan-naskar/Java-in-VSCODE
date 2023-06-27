import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class TreeFractal extends Frame {
    static double initialLen,stroke,startingAngle;
    static int depth,currDepth,counting=0;
    class Branch{
        double x,y,p,q,stroke,angle;

        public Branch(double x, double y, double p, double q, double stroke, double angle, Graphics g) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
            this.stroke = stroke;
            this.angle = angle;
            print(g);
        }        
        void print(Graphics gr){
            Graphics2D g = (Graphics2D)gr;
            Stroke sstroke = new BasicStroke((float)(10*(1-Math.log(depth==currDepth?0.5:depth-currDepth)/Math.log(depth))));
            g.setStroke(sstroke);
            g.setColor(new Color((int)stroke,(int)(Math.min(255,stroke*1.20)),(int)stroke));
            g.drawLine((int)x+610,1000-((int)y+20),(int)p+610,1000-((int)q+20));
            try{Thread.sleep(0);}
            catch(InterruptedException e){e.printStackTrace();}
        }

        void printFlower(Graphics g){
            // g.setColor(new Color(255,Math.random()>0.5?255:0,0));
            // int len;
            // g.fillOval((int)x+610, 1000-((int)y+20), len=(int)(15*Math.random()), len);
        }
    }



    public static void main(String[] args) {
        depth=18;
        stroke=255;//here i am using stroke as color, because i cudnt do stroke in line
        startingAngle=90.0;
        initialLen=200.0;
        new TreeFractal();
    }
    TreeFractal(){
        this.setSize(1220,1000);
        this.setVisible(true);
        this.setBackground(new Color(240,248,255));
    }
    public void paint(Graphics gr){
        if(counting++<2)return;
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        counting++;
        g.setColor(new Color(0,0,0));
        currDepth=depth;
        Branch root = new Branch((Math.random()-0.5)*100,0.0,0.0,initialLen,0.0,startingAngle,g);
        recurse(g,root,depth);
        // System.out.println(counting);
    }
    void recurse(Graphics g, Branch branch, int depth){
        if(depth==0){
            if(Math.random()>0.95)
                branch.printFlower(g); 
            return;
        }
        double angleL=branch.angle-Math.random()*40.0,angleR=branch.angle+Math.random()*40.0,
        len=distance(branch.x,branch.y,branch.p,branch.q)/1.25, base,
        x=(base=Math.cos(Math.toRadians(angleL))*len)+branch.p,y=Math.tan(Math.toRadians(angleL))*base+branch.q;
        
        double randomLenProb=Math.random();
        
        currDepth=depth;
        if(randomLenProb>0.5){
            Branch bL = new Branch(branch.p,branch.q,x,y,stroke-255*(depth/(double)TreeFractal.depth),angleL,g);
            recurse(g,bL,depth-1);
        }else{
            x=(base=Math.cos(Math.toRadians(angleL))*len*Math.max(Math.random(),0.65))+branch.p; y=Math.tan(Math.toRadians(angleL))*base+branch.q;
            Branch bL = new Branch(branch.p,branch.q,x,y,stroke-255*(depth/(double)TreeFractal.depth),angleL,g);
            recurse(g,bL,depth-1);
        }

        if(Math.random()>0.85){
            double angleM=branch.angle+((Math.random()-0.5)*30.0);
            x=(base=Math.cos(Math.toRadians(angleM))*len)+branch.p; y=Math.tan(Math.toRadians(angleM))*base+branch.q;

            currDepth=depth;
            Branch bM = new Branch(branch.p,branch.q,x,y,stroke-255*(depth/(double)TreeFractal.depth),angleM,g);
            recurse(g,bM,depth-1);
        }

        currDepth=depth;
        if(randomLenProb>0.5){
            x=(base=Math.cos(Math.toRadians(angleR))*len*Math.max(Math.random(),0.65))+branch.p; y=Math.tan(Math.toRadians(angleR))*base+branch.q;
            Branch bR = new Branch(branch.p,branch.q,x,y,stroke-255*(depth/(double)TreeFractal.depth),angleR,g);
            recurse(g,bR,depth-1);
        }else{
            x=(base=Math.cos(Math.toRadians(angleR))*len)+branch.p; y=Math.tan(Math.toRadians(angleR))*base+branch.q;
            Branch bR = new Branch(branch.p,branch.q,x,y,stroke-255*(depth/(double)TreeFractal.depth),angleR,g);
            recurse(g,bR,depth-1);
        }
    }
    double distance(double x, double y, double p, double q){
        return Math.sqrt(Math.pow(p-x,2)+Math.pow(q-y,2));
    }
}
