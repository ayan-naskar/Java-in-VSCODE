import java.util.HashMap;

import java.lang.String;
public class SendMoreMoney{
    static String send = "SEND", more = "MORE", money = "MONEY", reqCh = "MSENDORY";
    private HashMap<Integer, Character> map = new HashMap<Integer,Character>();
    public static void main(String[] args){
        SendMoreMoney ob = new SendMoreMoney();
        ob.decrypt();
    }

    private void decrypt(){
        go(0);
    }
    private void go(int index){
        if(index==0){
            map.put(1,reqCh.charAt(index));
            go(index+1);  
            return;
        }
        if(index>=reqCh.length()){
            String sen=send,mor=more,mon=money;
            for(int i=0;i<=9;i++){
                if(map.containsKey(i)){
                    char old=map.get(i),_new = (char)(i+'0');
                    sen=sen.replace(old,_new);
                    mor=mor.replace(old,_new);
                    mon=mon.replace(old, _new);
                }
            }
            if(Integer.valueOf(sen)+Integer.valueOf(mor)==Integer.valueOf(mon)){
                System.out.println(send+" + "+more+" = "+money);
                System.out.println(sen+" + "+mor+" = "+mon);
            }
            return;
        }
        for(int i=0;i<=9;i++){
            
            if(!map.containsKey(i)){
                map.put(i,reqCh.charAt(index));
                go(index+1);   
                map.remove(i);
            }
            
        }
    } 
}