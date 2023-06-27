import java.util.Date;

public class PrimeNormal {
    public static void main(String[] args) {
        int start=1,end=100000;
        int nos=1;
        long startT = System.currentTimeMillis();
        rangePrime(1,100000);
        long endT = System.currentTimeMillis();
        System.out.println("\nMain Execution complete!: Execution Time: "+ (endT-startT));

    }
    static public void rangePrime(int start, int end){
        for(int i=start;i<=end;i++){
            if(isPrime(i)) System.out.print(i+"\t");
        }
    }

    static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<n;i++)
        if(n%i==0)return false;
        return true; 
    }
}
