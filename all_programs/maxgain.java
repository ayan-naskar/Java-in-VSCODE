package all_programs;
import java.util.*;
//WRONG ANSWER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class maxgain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t,n,m,cases=1,i,res;
        t=sc.nextInt();
        
        while(t-->0){
            n=sc.nextInt();
            sc.nextLine();
            String line[]=sc.nextLine().split(" ");
            int aurr[]=new int[n];
            for(i=0;i<n;i++)aurr[i]=Integer.valueOf(line[i]);
            m=sc.nextInt();
            sc.nextLine();
            line=sc.nextLine().split(" ");
            int airr[]=new int[m];
            for(i=0;i<m;i++)airr[i]=Integer.valueOf(line[i]);
            int count=sc.nextInt();

            int aleft=0,aright=n-1,
                bleft=0,bright=m-1;
            res=0;
            while(count-->0){
                if(aurr[aleft]>=aurr[aright] && aurr[aleft]>=airr[bleft] && aurr[aleft]>=airr[bright] && aleft<=aright){
                    res+=aurr[aleft];
                    aleft++;
                }else if(aurr[aright]>=aurr[aleft] && aurr[aright]>=airr[bleft] && aurr[aright]>=airr[bright] && aleft<=aright){
                    res+=aurr[aright];
                    bright--;
                }else if(airr[bleft]>=airr[bright] && airr[bleft]>=aurr[aleft] && airr[bleft]>=aurr[aright] && bleft<=bright){
                    res+=airr[bleft];
                    bleft++;
                }else if(airr[bright]>=airr[bleft] && airr[bright]>=aurr[aleft] && airr[bright]>=aurr[aright] && bleft<=bright){
                    res+=airr[bright];
                    bright--;
                }
                System.out.println(res);
            }
            System.out.println("Case #"+ cases++ +": "+res);
        }
        sc.close();
    }
}
/*
 * 
1
3
3 1 2
4
2 8 1 9
5

 */