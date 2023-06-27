import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.util.Arrays;

public class gameOfLife extends Frame{
    public static void main(String[] args) {
        new gameOfLife();
    }
    gameOfLife(){
        this.setSize(1040,840);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        Simulation ob = new Simulation(new int[]{100,80});
        ob.setRandomLife(5000);
        fillspaceship(ob.world);
        int counter=0;
        while(true){
            g.setColor(new Color(0,0,0));
            g.fillRect(20,20,1000,800);
            
            g.setColor(new Color(255,0,0));
            String generation="Generation: "+counter++;
            g.drawString(generation, 20, 830);

            paintWorld(ob,g);
            // printWorld(ob.world);

            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
            ob.simulateNextGen();
        }
    }

    void fillspaceship(int[][] wd){
        wd[6][6+10]=wd[7][7+10]=wd[7][8+10]=wd[8][6+10]=wd[8][7+10]=1;
    }

    void printWorld(int[][] mat){
        for(int[] arr: mat) System.out.println(Arrays.toString(arr));
    }
    
    void paintWorld(Simulation ob, Graphics g){
        g.setColor(new Color(255,255,255));
        for(int i=0;i<ob.dimension[0];i++)
            for(int j=0;j<ob.dimension[1];j++)
                if(ob.world[i][j]==1) g.fillOval(i*10+20,j*10+20,10,10);
    }
}

class Simulation{
    int[][] world;
    int[] dimension;
    Simulation(int[] dimension){
        this.dimension = dimension;
        world = new int[dimension[0]][dimension[1]];
    }

    void setRandomLife(int lifeCount){
        for(int i = 0,x,y;i<lifeCount;i++){
            while(true){
                x=(int)(Math.random()*dimension[0]);
                y=(int)(Math.random()*dimension[1]);
                if(world[x][y]==0) break;
            }
            world[x][y]=1;
        }
    }

    void simulateNextGen(){
        int[][] world = new int[dimension[0]][dimension[1]];
        for(int i=0;i<dimension[0];i++){
            for(int j=0, count;j<dimension[1];j++){
                count = countNeightbours(i,j);
                if(this.world[i][j]==1){
                    if(count==2 || count==3) world[i][j]=1;
                }else{
                    if(count==3){
                        world[i][j]=1;
                    }
                }
            }
        }
        this.world=world;
    }

    int countNeightbours(int x, int y){
        int count=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0 && i<dimension[0] && j>=0 && j<dimension[1] && world[i][j]==1 ){ 
                    if(i==x && j==y)continue;
                    count++;
                }
            }
        }
        return count;
    }
}
