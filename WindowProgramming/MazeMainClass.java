import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;





public class MazeMainClass extends Frame{
    MaizeGrid maze;
    MazeGenerator mg;
    Graphics2D gg;
    static int offsetx, offsety;
    static int canvasWidth=1200, canvasHeight=1000;
    static int side = (int)((double)canvasHeight/(MazeGenerator.N*1.1));

    MazeMainClass(){
        this.setSize(canvasWidth,canvasHeight);
        this.setVisible(true);
        this.setBackground(new Color(240,248,255));     
        offsetx=50;
        offsety=70;
    }
    public static void main(String[] args) {
        new MazeMainClass();
    }

    public void paint(Graphics gr) {
        new Scanner(System.in).nextLine();
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(255,0,255));

        new MaizeGrid(MazeGenerator.M, MazeGenerator.N);
        // printMaize(g);
        System.out.println("Done");

        mg = new MazeGenerator();
        gg=g;
        mg.dfs(); 
        
        printMaize(g);
        System.out.println("Completed");
        // System.exit(0);
        // try{Thread.sleep(1000000);}
        // catch(InterruptedException t){t.printStackTrace();}
        MazeRunner.dfs(MaizeGrid.grid[0][0],g,3);
        MazeRunner.dfs(MaizeGrid.grid[0][0],g,4);
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        sc.close();
        
    }

    private void printMaize(Graphics g){
        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,canvasWidth,canvasHeight);
        for(int i=0;i<MazeGenerator.M;i++){
            for(int j=0;j<MazeGenerator.N;j++){
                // System.out.println(i+" "+j);
                if(MaizeGrid.grid[i][j].isExplored>0) g.setColor(new Color(255,255,255));
                else g.setColor(new Color(255,200,255));
                if((i==0 && j==0) || (i==MazeGenerator.M-1 && j==MazeGenerator.N-1)) g.setColor(new Color(255,0,0));
                int p=MaizeGrid.grid[i][j].x*side + offsetx,q=MaizeGrid.grid[i][j].y*side + offsety;
                g.fillRect(p, q, (int)(side*1), (int)(side*1));            
                          
            }
        }
        g.setColor(new Color(0,0,0));
        Stroke sstroke = new BasicStroke((float)8*side/100);
        ((Graphics2D) g).setStroke(sstroke);
        for(int i=0;i<MazeGenerator.M;i++){
            for(int j=0;j<MazeGenerator.N;j++){
                if((i==0 && j==0) || (i==MazeGenerator.M-1 && j==MazeGenerator.N-1)) continue;

                
                int p=MaizeGrid.grid[i][j].x*side + offsetx,q=MaizeGrid.grid[i][j].y*side + offsety;
                if(MaizeGrid.grid[i][j].rightWall) g.drawLine(p, q+side, p+side, q+side);
                if(MaizeGrid.grid[i][j].bottomWall) g.drawLine(p+side, q, p+side, q+side);

                // g.setColor(new Color(0,200,0));
                if(i==0) g.drawLine(offsetx, j*side+offsety, offsetx, j*side+offsety+side);
                if(j==0) g.drawLine(i*side+offsetx,  offsety, i*side+offsetx+side, offsety);
            }
        }
    }

























    public class MazeGenerator {
        public static final int M = 40, N = 40;
        
        public void dfs(){
            Stack<Cell> stack = new Stack<>();
            stack.add(MaizeGrid.grid[0][0]);
            while(!stack.isEmpty()){
                // System.out.println("");
                Cell e = stack.peek();
                e.isExplored=1;
                List<Cell> list = getUnvisitedCellList(e,1);
                // printMaize(gg);
                // gg.setColor(new Color(255,0,0));
                // gg.fillRect(e.x*side + offsetx, e.y*side + offsety, side, side);
                
    
                if(list.size()>0){
                    Cell nextCell = list.get((int)(Math.random()*list.size()));
                    stack.add(nextCell);
                    Cell.removeWall(e, nextCell);
                    // list = getUnvisitedCellList(e);
                }            
                else if(list.size()==0) stack.pop();
                // try{Thread.sleep(100);}
                // catch(InterruptedException t){t.printStackTrace();}
        
            }
        }
    
    }
    public static List<Cell> getUnvisitedCellList(Cell e, int val){
        List<Cell> list = new ArrayList<>();
        if(!e.isUpExplored(val)) list.add(e.getUpperCell());
        if(!e.isRightExplored(val)) list.add(e.getRightCell());
        if(!e.isBottomExplored(val)) list.add(e.getBottomCell());
        if(!e.isLeftExplored(val)) list.add(e.getLeftCell());
        
        return list;
    }
    public static List<Cell> getUnvisitedCellList2(Cell e, int val){
        List<Cell> list = new ArrayList<>();
        // Cell[][] gr=MaizeGrid.grid;
        // if(!e.isUpExplored(val)) System.out.println(!MaizeGrid.grid[e.x][e.y].bottomWall);
        if(!e.isUpExplored(val) && !MaizeGrid.grid[e.x-1][e.y].bottomWall) list.add(e.getUpperCell());
        if(!e.isRightExplored(val) && !e.rightWall) list.add(e.getRightCell());
        if(!e.isBottomExplored(val) && !e.bottomWall) list.add(e.getBottomCell());
        if(!e.isLeftExplored(val) && !MaizeGrid.grid[e.x][e.y-1].rightWall) list.add(e.getLeftCell());
        
        return list;
    }
}
