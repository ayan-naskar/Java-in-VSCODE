import java.util.HashSet;
public class Sender implements Runnable{
    private static final int m = 2;
    String str;
    Sender(String str){
        this.str=str;
    }

    public void run() {
        System.out.println("The data to be transmitted: "+str);
        String data = str;

        int frameSize = (int)Math.pow(2,m) - 1;
        int connectionNumber = Medium.data.size();
        Medium.data.add("");
        Medium.sequenceNumber.add(Integer.MIN_VALUE);
        Medium.ack.add(0);
        data+="%";
        for(int i=0;i<data.length();){
            String frame = data.substring(i,Math.min(i+frameSize, data.length()));
            System.out.println("Frame currently being sent is: "+frame+", for Connection Number: "+connectionNumber);
            this.send(i, frame, connectionNumber, frame.length());
            int a = Medium.ack.get(connectionNumber);
            double packetLoss = 100.0-((a-i+1)*100.0)/frame.length();     
            i = Math.max(0, a+1);
            System.out.println("Acknowledgement received for: "+a+",  Connection Number:"+connectionNumber);       

            System.out.println("(Packet Loss is: "+(int)packetLoss+"%)");
        }
        System.out.println("Transmission Complete for: "+connectionNumber);
    }

    void send(int seq_num, String s, int connectionNumber, int frameSize) {
        HashSet<Integer> set = new HashSet<Integer>();
        // int ii=0;
        while(frameSize-- > 0){
            int n = (int)(Math.random()*frameSize); //with frame sending errors
            // n=ii++; // with no error in sending frames
            if(!set.contains(n)){
                Medium.sequenceNumber.set(connectionNumber, seq_num+n);
                Medium.data.set(connectionNumber, s.charAt(n)+"");
            }
            set.add(n);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
