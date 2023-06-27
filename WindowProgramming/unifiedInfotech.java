import java.util.*;
public class unifiedInfotech {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,q,type,x,y;
        // String[] line = sc.nextLine().split(" ");
        // n=Integer.valueOf(line[0]);
        // q=Integer.valueOf(line[1]);
        n=sc.nextInt();
        q=sc.nextInt();
        long a[]=new long[n];
        for(int i=0;i<q;i++){
            // line = sc.nextLine().split(" ");
            // type=Integer.valueOf(line[0])-1;
            // x=Integer.valueOf(line[1])-1;
            type=sc.nextInt();
            x=sc.nextInt()-1;
            switch(type){
                case 1:
                    a[x]=2*a[x]+1;
                    break;
                case 2:
                    a[x]=f(a[x]/2);
                    break;
                case 3:
                    // y=Integer.valueOf(line[2]);
                    y=sc.nextInt()-1;
                    long sum=0L;
                    for(int j=x;j<=y;j++){
                        sum+=a[j];
                    }
                    System.out.println(sum);
            }
        }
    }
    private static long f(long x){
        return (long)Math.min((long)Integer.MAX_VALUE,x);
    }
}
