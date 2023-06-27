import java.util.*;
class Solution{
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t,n,i,j;
        t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            n=sc.nextInt();
            sc.nextLine();
            String s=sc.nextLine();
            // String res = s.charAt(0)+"";
            int lastvalid=1,k;
            for(i=1;i<n;i++){
                j=lastvalid;
                k=n-1;
                int flag=0;
                while(j<n && s.charAt(j)==s.charAt(k)){
                    j++;
                    k--;
                    if(j==k || (j-k)==1){
                        flag=1;
                        break;
                    }
                }
                if(flag==1)break;
                // res=s.charAt(lastvalid)+res;
                lastvalid++;
            }
            System.out.println("Case #"+i+": "+reverse(s.substring(0,lastvalid)));
        }
    }
}