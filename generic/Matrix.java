public class Matrix <T extends Object>{
   private T mat[][];
   private int row;
   private int col;

    Matrix(int r,int c)
    {
        this.row=r;
        this.col=c;
    }

    public void setMatrix(Object M[][])
    {
        this.mat=(T[][])M;
    }

    @Override
    public String toString()
    {
        String s="";
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
                s=s+mat[i][j].toString()+"\t";
            s=s+"\n";
        }
        return s;
    }  

}
