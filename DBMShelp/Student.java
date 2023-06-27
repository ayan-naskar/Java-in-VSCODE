public class Student {
    class City{
        static String getCity(){
            String[] city = {"Kolkata","Malda","Asansol","Siliguri","Durgapur"};
            return city[(int)(Math.random()*5)];
        }
    }
    public class Names {
        static String firstName[] = {"Ayan","Sounak","Shankha","Joy","Ayantika","Sayan","Riya","Payel","Soumya","Soumik","Raj","Abhishek","Raskesh","Aritra"};
        static String secondName[] = {"Naskar","Mukherjee","Chakraborty","Ghosh","Halder","Chatterjee","Pal","Dalal","Das","Jana"};
        public static String[] getName(){
            String f=firstName[(int)(Math.random()*14)];
            String l=secondName[(int)(Math.random()*10)];
            String s[]=new String[2];
            s[0]=f;
            s[1]=l;
            return s;
        }
    }
    public static int getMonth(){
        String s=(int)(Math.random()*12+1)+"";
        if(s.length()==1) s="0"+s;
        return (int)(Math.random()*12);
    }
    public static String getDay(){
        String s=(int)(Math.random()*28+1)+"";
        if(s.length()==1) s="0"+s;
        return s;
    }
    static String month[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    public static void main(String[] args) {
        for(int i=0; i<20; i++){
            String student[] = Names.getName();
            String add[]=Names.getName();
            System.out.println("insert into Student values ("+
            (int)(Math.random()*4+1)+", 144001200"+((i+1<10)?"0":"")+
            (i+1)+", '"+
            student[0].toLowerCase()+student[1].toLowerCase()+(int)(Math.random()*100)+"@gmail.com', "+
            (long)(Math.random()*1000000000.0+9000000000.0)+", '"+
            (int)(Math.random()*50+1)+"', '"+
            add[0]+" "+add[1]+" Road', '"+
            City.getCity()+"', "+
            "'West Bengal'"+", "+
            (int)(Math.random()*100000.0+700000)+", '"+
            getDay()+"-"+month[getMonth()]+"-"+"200"+(int)(Math.random()*4)+"', '"+
            student[0]+"', '"+
            student[1]+"');");
        }
    }
}