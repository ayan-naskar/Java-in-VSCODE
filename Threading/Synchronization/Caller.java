public class Caller implements Runnable{
    String msg;
    CallMe target;
    Thread t;
    public Caller(CallMe targ,String s)
    {
        this.msg=s;
        this.target=targ;
        this.t=new Thread(this);
        t.start();
    }

    @Override
    public void run()
    {
        synchronized(target){
            target.call(this.msg);
        }
    }
}
