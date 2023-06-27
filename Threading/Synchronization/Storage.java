public class Storage {
    public static int data=-1;

    synchronized static void update(int d)
    {
        Storage.data=d;
    }
    public static int getValue()
    {
        return Storage.data;
    }
}
