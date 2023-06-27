import java.util.*;
class Codechef
{
	public static void main (String[] args)
	{
	    Scanner sc=new Scanner(System.in);
	    int t=Integer.valueOf(sc.nextLine());
		while(t-->0){
		    int n=Integer.valueOf(sc.nextLine());
		    String str = sc.nextLine();
		    char [] s=str.toCharArray();
		    int op=0,plus=0,minus=0;
		    int[] freq=new int[10];
		    for(char ch: s){
		        if("+-".indexOf(ch)>=0){
		            op++;
		            if(ch=='+')plus++;
		            else minus++;
		        }
		        else{
		            freq[(int)ch-48]+=1;
		        }
		    }
		    int v=n-op*2,k=9;
		    while(v>0){
		       if(freq[k]==0){
		           k--;
		       }else{
		           freq[k]--;
                   v--;
		           System.out.print(k);
		       }
		    }
            for(int i=1;i<=plus;i++){
                // System.out.println("--"+k);
		       if(freq[k]==0){
		           i--;
		           k--;
		       }else{
                    System.out.print("+");
		           freq[k]--;
		           System.out.print(k);
		       }
            }
            for(int i=1;i<=minus;i++){
		       if(freq[k]==0){
		           i--;
		           k--;
		       }else{
                    System.out.print("-");
		           freq[k]--;
		           System.out.print(k);
		       }
            }
            System.out.println();
		    
		}
		// your code goes here
	}
}
/*
1
7
4-89+20

 */