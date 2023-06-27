package w;

import java.util.*;
class Solution{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int t=Integer.valueOf(sc.nextLine()),m,n,p,i,j,T,rs,rh,x,y,red,yellow;
        for(T=1;T<=t;T++){
            String[] line=sc.nextLine().split(" ");
            rs=Integer.valueOf(line[0]);
            rh=Integer.valueOf(line[1]);
            n=Integer.valueOf(sc.nextLine());
            double[][] narr=input(n);
            m=Integer.valueOf(sc.nextLine());
            double[][] marr=input(m);

            Arrays.sort(narr,(a,b)->(a[2]-b[2])<0?-1:1);
            Arrays.sort(marr,(a,b)->(a[2]-b[2])<0?-1:1);

            red=yellow=0;
            while(red<n || yellow<m){
                if((red>=n || isObsolete(narr[red],rs,rh)) && (yellow>=m || isObsolete(marr[yellow],rs,rh))){ 
                    // System.out.println(isObsolete(narr[red],rs,rh));
                    // System.out.println(Arrays.toString(narr[red]));
                    // System.out.println(isObsolete(marr[yellow],rs,rh));
                    break;
                }
                // System.out.println("here----------------------->");

                if(red<n && (yellow>=m || narr[red][2]<marr[yellow][2])){
                    if(red==0 && yellow!=0) break;
                    red++;
                }else{
                    if(red!=0 && yellow==0) break;
                    yellow++;
                }
            }
            System.out.println("Case #"+T+": "+red+" "+yellow);
        }
    }
    static boolean isObsolete(double[] arr, int rs, int rh){
        return (rs+rh)<arr[2];
    }
    static double[][] input(int n){
        double narr[][]=new double[n][3];
        for(int i=0,x,y;i<n;i++){
            String[] line=sc.nextLine().split(" ");
            x=Integer.valueOf(line[0]);
            y=Integer.valueOf(line[1]);
            narr[i][0]=x; narr[i][1]=y; narr[i][2]=Math.sqrt(x*x+y*y); 
        }
        return narr;
    }
}
