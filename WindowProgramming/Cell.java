public class Cell{
    int isExplored=0; // 0 means false
    boolean rightWall=true, bottomWall=true;
    int x,y;
    public Cell getUpperCell() {
        if(x==0) return null;
        return MaizeGrid.grid[x-1][y];
    }
    public boolean isUpExplored(int val) {
        if(x==0) return true;
        // if(val==3)
        // System.out.println("Expplored value="+MaizeGrid.grid[x-1][y].isExplored);
        return MaizeGrid.grid[x-1][y].isExplored==val;
    }
    public Cell getRightCell() {
        if(y+1==MaizeGrid.n) return null;
        return MaizeGrid.grid[x][y+1];
    }
    public boolean isRightExplored(int val) {
        if(y==(MaizeGrid.n-1)) return true;
        return MaizeGrid.grid[x][y+1].isExplored==val;
    }
    public Cell getBottomCell() {
        if(x+1==MaizeGrid.m) return null;
        return MaizeGrid.grid[x+1][y];
    }
    public boolean isBottomExplored(int val) {
        if(x==(MaizeGrid.m-1)) return true;
        return MaizeGrid.grid[x+1][y].isExplored==val;
    }
    public Cell getLeftCell() {
        if(y==0) return null;
        return MaizeGrid.grid[x][y-1];
    }
    public boolean isLeftExplored(int val) {
        if(y==0) return true;
        return MaizeGrid.grid[x][y-1].isExplored==val;
    }
    public static void removeWall(Cell e, Cell nextCell) {
        if(e.getUpperCell()!=null && e.getUpperCell().x==nextCell.x && e.getUpperCell().y==nextCell.y) nextCell.bottomWall=false;
        if(e.getRightCell()!=null && e.getRightCell().x==nextCell.x && e.getRightCell().y==nextCell.y) e.rightWall=false;
        if(e.getBottomCell()!=null && e.getBottomCell().x==nextCell.x && e.getBottomCell().y==nextCell.y) e.bottomWall=false;
        if(e.getLeftCell()!=null && e.getLeftCell().x==nextCell.x && e.getLeftCell().y==nextCell.y) nextCell.rightWall=false;
    }
}