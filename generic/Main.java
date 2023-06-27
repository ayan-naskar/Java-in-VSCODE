import java.util.*;
public class Main {
	public static void main(String[] args) {
		System.out.println("The Answer is: "+solve(5,4,new int[]{6,7,5,27,3}));
	}


    static HashMap<String,Integer> map = new HashMap<String,Integer>();
    static int resgcd=0;
    public static int solve(int N, int K, int[] arr) {
        map.put(N+" 0",0);
        System.out.println(go(0,arr,N,K,0));
        System.out.println(map.size());
        return resgcd;
    }
    private static int go(int i,int[] arr, int n, int k, int gcd) {
        // if(n<k)System.out.println("yes "+n+" "+k);
        if(k<=0) return 0;
        // System.out.println(":k="+k);
        int j,sum=0,__gcd,val,goret,maxgcdinfunc=1,rcount=n-i;
        for(j=0;j<(rcount-k+1);j++){
            // System.out.println("k="+k+"     looop to "+(rcount-k+1));
            // System.out.println("...."+i+" "+j);

            sum+=arr[i+j];
            val = _gcd(gcd,sum);
            String str = (i+j+1)+" "+(k-j-1);
            if(map.containsKey(str)){
                __gcd = _gcd(val,map.get(str));
                resgcd = Math.max(__gcd,resgcd);
            }else{
                goret = go(i+j+1,arr,n,k-j-1,val);
                __gcd = _gcd(val,goret);
                System.out.println("The String is: " + str);
                map.put(str,goret);
                resgcd = Math.max(__gcd,resgcd);
            }
            maxgcdinfunc = Math.max(maxgcdinfunc,_gcd(sum,map.get(str)));
        }
        return maxgcdinfunc;
    }
    private static int _gcd(int a, int b) {
        if (b == 0) return a;
        else return _gcd(b, a % b);
    }
}

