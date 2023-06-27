import java.util.*;
public class test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int ar[]=  new int[26];
        for(int i=0;i<26;i++){
            ar[i]=sc.nextInt();
        }
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                int d=map.get(ch);
                if(ar[ch-'a']!=(i-d-1)){
                    System.out.println("False");
                    return;
                }
            }else{

                map.put(ch,i);
            }
        }
        System.out.println("true");
    }
}
