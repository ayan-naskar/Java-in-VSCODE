public class MainClass {
    static String data[]={"AyanNaskar","SounakMukherjee"};  //,"ShankhaChatterjee","SoumikJana","AyantikaNaskar"};
    public static void main(String[] args) throws Exception{
        Receiver r=new Receiver();
        new Thread(r).start();

        for(int i=0;i<data.length;i++){
            Sender s=new Sender(data[i]);
            new Thread(s).start();
            Thread.sleep(400);
        }
    }
}
