public class Printer extends Thread{
    Thread t;
    boolean exit;
    public Printer(){
        this.t = new Thread(this);
        this.exit=false;
        t.start();
    }    
    @Override
    public void run(){
        while(!exit){
            // System.out.println("Printer here!");
            if(Storage.getValue()!=-1)
            {
                System.out.print(Storage.getValue()+"\t");
                Storage.update(-1);
            }
            else 
            {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }

        
    }
    public void stopPrinter()
    {
        this.exit=true;
    }
    
}