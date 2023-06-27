/*public class MyThread extends Thread{
    Thread t;

    MyThread(String threadname)
    {
        t=new Thread(this,threadname);
        System.out.println("Child Thread "+t+" Created!");
        t.start();
    }
    @Override
    public void run()
    {
        try {
            for(int i=5;i>=1;i--)
            {
                System.out.println("Child Thread["+t+"]: "+i);
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            System.out.println("Child Thread Exited....");
        }
    }
}
*/
public class MyThread implements Runnable
{
    Thread t;

    MyThread(String threadname)
    {
        t=new Thread(this,threadname);
        System.out.println("Child Thread "+t+" Created!");
        t.start();
    }
    @Override
    public void run()
    {
        try {
            for(int i=5;i>=1;i--)
            {
                System.out.println("Child Thread["+t+"]: "+i);
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            System.out.println("Child Thread Exited....");
        }
    }
}