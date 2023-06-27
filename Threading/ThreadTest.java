class ThreadTest {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        System.out.println(t);
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isAlive());
        System.out.println(t.isDaemon());
        t.setName("NewMain");
        t.setPriority(4);
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isAlive());
        System.out.println(t.isDaemon());
        try{
            System.out.println("Go to sleep!");
            Thread.sleep(2000);
            System.out.println(t.isAlive());
            System.out.println("Wake up!");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}