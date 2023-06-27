public class MaizeGrid {
    static int m,n;
    static Cell grid[][];
    MaizeGrid(int m, int n) {
        MaizeGrid.m=m;
        MaizeGrid.n=n;
        grid = new Cell[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                grid[i][j]=new Cell();
                grid[i][j].x=i;
                grid[i][j].y=j;
            }
    }
}
