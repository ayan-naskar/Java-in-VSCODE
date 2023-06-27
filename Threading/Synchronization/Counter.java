public class Counter extends Thread {
    Thread t;
    boolean exit;
    public Counter(){
        this.t = new Thread(this);
        this.exit=false;
        t.start();
    }
    @Override
    public void run(){
        for(int i=0;!exit;){
            // System.out.println("counter here!");
            if(Storage.getValue()==-1)
                Storage.update(i++);
            else
            {
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void stopCounter()
    {
        this.exit=true;
    }
}