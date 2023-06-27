public class Faculty {
    public class Names {
        static String firstName[] = {"Tarun","Souvik","Sunanda","Kollol","Gopinath","Debabrata","Suman","Mitali","Hemanta","Bappaditya"};
        static String secondName[] = {"Naskar","Mukherjee","Chakraborty","Ghosh","Halder","Chatterjee","Pal","Dalal","Das","Jana"};
        public static String[] getName(){
            String f=firstName[(int)(Math.random()*10)];
            String l=secondName[(int)(Math.random()*10)];
            String s[]=new String[2];
            s[0]=f;
            s[1]=l;
            return s;
        }
    }
    class City{
        static String getCity(){
            String[] city = {"Kolkata","Malda","Asansol","Siliguri","Durgapur"};
            return city[(int)(Math.random()*5)];
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
        for(int i=0;i<10;i++){
            String fac[] = Names.getName();
            String add[]=Names.getName();
            System.out.println("insert into Faculty values ("+((int)(Math.random()*4+1))+", "+(i+1)+", '"+
            fac[0].toLowerCase()+"."+fac[1].toLowerCase()+"@nitmas.org', "+
            ((long)(Math.random()*1000000000.0+9000000000.0))+", "+
            ((int)(Math.random()*25+1))+", '"+
            add[0]+" "+add[1]+" Road', 'West Bengal', "+
            ((long)(Math.random()*100000+700000.0))+", '"+
            City.getCity()+"', '"+
            getDay()+"-"+month[getMonth()]+"-19"+(int)(Math.random()*15+70)+"', "+
            "'"+fac[0]+"', '"+fac[1]+"');"
            );
        }
    }
}
