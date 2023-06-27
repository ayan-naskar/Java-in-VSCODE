package q;

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=Integer.valueOf(sc.nextLine()),m,n,p,i,j,T;
        for(T=1;T<=t;T++){
            String[] line=sc.nextLine().split(" ");
            m=Integer.valueOf(line[0]);
            n=Integer.valueOf(line[1]);
            p=Integer.valueOf(line[2]);
            int arr[]=new int[n],john[]=new int[n],res=0;
            for(i=0;i<m;i++){
                line=sc.nextLine().split(" ");
                for(j=0;j<n;j++){
                    arr[j]=Math.max(arr[j],Integer.valueOf(line[j]));
                    if(i+1==p) john[j]=Integer.valueOf(line[j]);
                }
            } 
            for(j=0;j<n;j++){
                res+=Math.max(0,arr[j]-john[j]);
            }
            System.out.println("Case #"+T+": "+res);
        }
    }
}
