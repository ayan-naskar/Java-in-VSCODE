import java.util.HashSet;
import java.util.PriorityQueue;
public class Sender implements Runnable{
    PriorityQueue<Integer> pq;
    int frameToSend=0;

    private static final int m = 2;
    String str;
    Sender(String str){
        this.str=str;
        pq = new PriorityQueue<>();
    }

    public void run() {
        System.out.println("The data to be transmitted: "+str);
        String data = str;

        int frameSize = (int)Math.pow(2,m) - 1;
        int connectionNumber = Medium.data.size();
        Medium.data.add("");
        Medium.ack.add(Integer.MAX_VALUE);

        AcknowledgementChecker ac = new AcknowledgementChecker(connectionNumber);
        new Thread(ac).start();

        data+="%";
        for(int i=0;i<data.length();){
            String frame = data.substring(i,Math.min(i+frameSize, data.length()));
            if(!frame.equals("%"))
            System.out.println("Frame currently being sent is: "+frame+", for Connection Number: "+connectionNumber);
            this.send(i, frame, connectionNumber, frame.length());
            i=frameToSend;
        }
        System.out.println("Transmission Complete for: "+connectionNumber);
    }
    
    void send(int seq_num, String s, int connectionNumber, int frameSize) {
        HashSet<Integer> set = new HashSet<Integer>();
        int ii=0;
        while(frameSize-- > 0){
            int n = (int)(Math.random()*frameSize); //with frame sending errors
            // n=ii++; // with no error in sending frames
            if(!set.contains(n)){
                if(Math.random()>0.5)
                Medium.data.set(connectionNumber, (seq_num+n)+":"+s.charAt(n)+"");
            }
            set.add(n);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    class AcknowledgementChecker implements Runnable {
        int connectionNumber;
        AcknowledgementChecker(int connectionNumber){
            this.connectionNumber = connectionNumber;
        }
        public void run(){
            HashSet<Integer> set = new HashSet<>();
            while(true){
                int an = Medium.ack.get(connectionNumber);
                if(!set.contains(an)){
                    set.add(an);
                    pq.add(an);
                    System.out.println("Acknowledgement received for: "+an+",  Connection Number:"+connectionNumber);       
                }
                while(!pq.isEmpty() && (pq.peek()==frameToSend)){
                    pq.poll();
                    frameToSend++;
                    System.out.println("Frame to send : "+frameToSend);
                }
            }
        }
    }
}
