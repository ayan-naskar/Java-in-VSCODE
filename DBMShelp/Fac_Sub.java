import java.util.List;

public class Fac_Sub {
    public static void doit(List<String> list) {
        for(int i=0;i<25;i++){
            System.out.println("insert into Fac_Sub values ("+(int)(Math.random()*10+1)+", '"+list.get(i)+"');");
        }
    }
}
