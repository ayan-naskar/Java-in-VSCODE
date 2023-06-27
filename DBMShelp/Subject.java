import java.util.ArrayList;
import java.util.HashSet;

public class Subject {
    public class Names {
        static String firstName[] = {"PCC","PEC","EOC"};
        static String secondName[] = {"CS","IT","SS"};
        static String thirdName[] = {"601","602","602C","601B","603A"};
        public static String getName(){
            String f=firstName[(int)(Math.random()*3)];
            String l=secondName[(int)(Math.random()*3)];
            String r=thirdName[(int)(Math.random()*5)];
            String s[]=new String[3];
            s[0]=f;
            s[1]=l;
            s[2]=r;
            return f+"-"+l+r;
        }
    }
    static String[] subject={"Computer Sciences",
        "Logic",
        "Mathematics",
        "Statistics",
        "Systems Science",
        "Numerical Methods",
        "Architecture and Design",
        "Business",
        "DBMS",
        "Computer Networks",
        "Engineering",
        "Environmental Studies and Forestry",
        "HCI",
        "Health Sciences",
        "Human Physical Performance and Recreation",
        "Ethics in Engineering",
        "Java",
        "C/C++",
        "Chemistry",
        "Python",
        "OS",
        "Physics",
        "Geometry",
        "Yoga",
        "Space Sciences"};
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<25;i++){
            System.out.print("insert into Subject values ('");
            while(true){
                String s = Names.getName();
                if(set.contains(s)) continue;
                System.out.print(s+"', '");
                list.add(s);
                set.add(s);
                break;
            }
            while(true){
                String s = subject[(int)(Math.random()*subject.length)];
                if(set2.contains(s)) continue;
                set2.add(s);
                System.out.println(s+"');");
                break;
            }
        }
        System.out.println("\n\n\n\n\n");
        Fac_Sub.doit(list);
        System.out.println("\n\n\n\n\n");
        Marks.doit(list);
    }
}
