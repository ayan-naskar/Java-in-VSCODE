import java.util.List;

public class Marks {
    public static void doit(List<String> list) {
        for(int i=0;i<50;i++){
            int x=(int)(Math.random()*20);
            System.out.println("insert into Marks values ('CA"+(int)(Math.random()*4+1)+"', "+
            (int)(Math.random()*4+1)+", 144001200"+((x+1<10)?"0":"")+(x+1)+", '"+
            list.get((int)(Math.random()*25))+"', "+
            (int)(Math.random()*10+15+1)+");");
        }
    }
}
