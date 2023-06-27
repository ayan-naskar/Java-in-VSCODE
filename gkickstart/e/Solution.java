package e;

// import java.util.*;
// class Solution{
//     static Scanner sc=new Scanner(System.in);
//     public static void main(String[] args){
//         int t=Integer.valueOf(sc.nextLine()),m,n,p,i,j,T,res;
//         for(T=1;T<=t;T++){
//             n=Integer.valueOf(sc.nextLine());
//             int arr[]=new int[n];
//             String[] line=sc.nextLine().split(" ");
//             for(i=0;i<n;i++){
//                 arr[i]=Integer.valueOf(line[i]);
//             }
//             res=0;
//             for(i=0;i<n;i++){
//                 int sum=0;
//                 for(j=i;j<n;j++){
//                     sum+=arr[j];
//                     if(sum<0)break;
//                     else{
//                         res+=sum;
//                     }
//                 }
//             }

//             System.out.println("Case #"+T+": "+res);
//         }
//     }
// }

import java.util.Scanner;
public class Solution {
    public static void ques(){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=1;i<=T;i++){
            int N=in.nextInt();
            int[]A=new int[N];
            for(int k=0;k<N;k++){
                A[k]=in.nextInt();
            }
            int ans=0,temp=-1;
            for(int j=0;j<N;j++){
                if(A[j]>0){
                    ans+=A[j];
                    if(temp<0)temp=i;
                }else{
                    if(j>0){
                        if(A[j]+A[j-1]>0){
                            ans+=A[j]+A[j-1];
                            temp=j-1;
                        }else{
                            temp=j+1;
                        }
                    }
                }
            }
            for(int s=temp;s<N;s++){
                if(A[s]<0)break;
                ans+=sum(s, N-1, A);
            }
            System.out.println("Case #"+i+": "+ans);  
        }
    }
    public static int sum(int l,int r,int[]arr){
        if(l==r || l>r)return 0;
        int sum=0;
        for(int i=l;i<=r;i++){
           sum+=arr[i];
        }
        if(sum>0)return sum;
        else return 0;
    }
    public static void main(String[] args) {
        ques();
    }
}