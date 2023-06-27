import java.util.Random;

public class PrimeInRange extends Thread {
    Thread t;
    int start,end;
    static Long startT;
    static Long totalTime;
    PrimeInRange(int start,int end,String threadname){
        t = new Thread(this,threadname);
        t.setPriority(new Random().nextInt(MIN_PRIORITY,MAX_PRIORITY));
        System.out.println("Priority: "+t.getPriority()+" name: "+t.getName());
        if(startT==null){ 
            startT = System.currentTimeMillis();
            totalTime=0L;
            System.out.println("start is null");
        }
        this.start=start;
        this.end=end;
        t.start();
    }
    @Override
    public void run(){
        try{
            // System.out.println(start+"    "+end);
            for(int i=start;i<=end;i++){
                if(isPrime(i)) System.out.print(i+"\t");
                Thread.sleep(0);
            }
            long st=System.currentTimeMillis()-startT;
            // long et=System.currentTimeMillis();
            // startT+=(et-st);
            totalTime = Math.max(totalTime,st);
            System.out.println("\nTime: "+totalTime+" of "+t.getName());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<n;i++)
        if(n%i==0)return false;
        return true; 
    }
}
