import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;

public class MazeRunner {
    public static void main(String[] args) {
        new MazeMainClass();
        // dfs(MaizeGrid.grid[0][0]);
    }

    static int dfs(Cell e, Graphics g, int algo){
        // System.out.println(e.x+" "+e.y);
        e.isExplored=algo;
        if(e.x==MaizeGrid.m-1 && e.y==MaizeGrid.n-1){
            System.out.println("Path Found!!");
            new Scanner(System.in).nextLine();
            return 1;
        }
        List<Cell> list = MazeMainClass.getUnvisitedCellList2(e,algo);
        if(algo==3)
            Collections.sort(list,(a,b)->manhattanDestDist(a)-manhattanDestDist(b));
        // System.out.println(list.size());
        for(Cell cell: list){
            int p=e.x*MazeMainClass.side + MazeMainClass.offsetx,q=e.y*MazeMainClass.side + MazeMainClass.offsety;
            int p2=cell.x*MazeMainClass.side + MazeMainClass.offsetx,q2=cell.y*MazeMainClass.side + MazeMainClass.offsety;
            if(algo==3)
                g.setColor(new Color(200,0,0));
            else g.setColor(new Color(0,0,200));

            g.drawLine(p+MazeMainClass.side/2+algo-3, q+MazeMainClass.side/2+algo-3, p2+MazeMainClass.side/2+algo-3, q2+MazeMainClass.side/2+algo-3);
            try{Thread.sleep(50);}
            catch(InterruptedException t){t.printStackTrace();}
            if(dfs(cell,g,algo)==1) return 1;
        }       
        return 0; 
    }
    public static int manhattanDestDist(Cell e) {
        int a=(int)Math.abs(MaizeGrid.m-e.x), b=(int)Math.abs(MaizeGrid.n-e.y);
        return a+b;
    } 
}
