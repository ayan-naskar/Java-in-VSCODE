
public class PrimeMain {
    public static void main(String[] args) {
        System.out.println("Time taken = "+PrimeInRange.totalTime);
        // if(true) return;
        int start=1,end=100000;
        int nos=1;
        long startT = System.currentTimeMillis();
        PrimeInRange pr[]=new PrimeInRange[15];
        int k=0;
        // try{
            for(int i=start;i<end;i+=(end-start)/10){
            pr[k]= new PrimeInRange(i,i+(end-start)/10-1,"Thread number: "+nos++);
                // pr[k].t.join();
                k++;
            }
        // }
        // catch(InterruptedException e)
        // {
        //     e.printStackTrace();
        // }
        for(int i=0;i<k;){
            if(pr[i].isAlive())
            {
                System.out.println("Alive: ");
                continue;
            }
            else 
                i++;
        }
        System.out.println("Time taken: "+PrimeInRange.totalTime);
        // new PrimeInRange(1,50000,"Thread number: ");
        // new PrimeInRange(50001,100000,"Thread number: ");
        long endT = System.currentTimeMillis();
        System.out.println("Main Execution complete!: Execution Time: "+ (endT-startT));

    }
}
