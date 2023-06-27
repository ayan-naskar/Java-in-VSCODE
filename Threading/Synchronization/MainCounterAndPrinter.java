public class MainCounterAndPrinter {
    public static void main(String[] args) {
        Counter c=new Counter();
        Printer p=new Printer();
        try{
            
            Thread.sleep(10000);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        c.stopCounter();
        p.stopPrinter();
        System.out.println("Stopped");
    }
}
