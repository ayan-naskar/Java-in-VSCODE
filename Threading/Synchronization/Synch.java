public class Synch {
    public static void main(String args[])
    {
        CallMe target=new CallMe();
        // Caller c1=new Caller(target,"House");
        // Caller c2=new Caller(target,"Of");
        // Caller c3=new Caller(target,"Dragons");

        try{
            // c1.t.join();
            // c2.t.join();
            // c3.t.join();
            new Caller(target,"House").t.join();
            new Caller(target,"Of").t.join();
            new Caller(target,"Dragons").t.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
    }
}
