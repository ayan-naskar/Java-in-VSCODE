public class MainThread {
    public static void main(String[] args) {
        new MyThread("Ayan");
        try{
            for(int i=5;i>=1;i--)
            {
                System.out.println("Main Thread["+Thread.currentThread()+"] : "+i);
                Thread.sleep(0);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            System.out.println("Main Thread Exited....");
        }
    }
}
