import java.util.HashSet;
public class Department {
    public static void main(String[] args) {
        String nam[]={"CSE","ECE","ROB","AGRO","ELE","HOSP","MAR"};
        HashSet<String> map = new HashSet<String>();
        for(int i=1;i<=4;i++){
            System.out.print("insert into Department values ("+i+", ");
            while(true){
                String s = nam[(int)(Math.random()*7)];
                if(map.contains(s)) continue;
                System.out.println("'"+s+"', 'Block-"+(char)(i-1+'A')+"', "+(int)(Math.random()*10+1)+");");
                map.add(s);
                break;
            }
        }
    }
}
