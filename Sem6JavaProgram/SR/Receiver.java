import java.util.HashMap;

public class Receiver implements Runnable{
    public void run() {
        int numberOfConnections = 0;

        while(true){
            int currConnections = Medium.data.size();
            if(currConnections > numberOfConnections){
                System.out.println("----New Client Connected.");
                numberOfConnections = currConnections;
                ClientHandler ob = new ClientHandler(currConnections-1);
                new Thread(ob).start();
            }
        }
    }

    static class ClientHandler implements Runnable{
        int connectionNumber;
        ClientHandler(int connectionNumber){
            this.connectionNumber = connectionNumber;
        }

        public void run(){
            String final_data="";
            Integer size = null;
            HashMap<Integer, String> map = new HashMap<Integer,String>();
            while(true) {
                try {Thread.sleep(133);} 
                catch (InterruptedException e) {e.printStackTrace();}
                String d[] = Medium.data.get(connectionNumber).split(":");
                if(d[0].equals("")) continue;
                int seq_num = Integer.valueOf(d[0]);


                if(!map.containsKey(seq_num)){
                    String data = d[1];
                    System.out.println("----Data received: "+data+",  for Connection Number: "+connectionNumber);

                    if(Math.random()>0.75) // with acknowledgement errors
                    Medium.ack.set(connectionNumber, seq_num);
                    if(data.equals("%")) size = seq_num;
                    else map.put(seq_num, data);
                    if(size!=null && size>=map.size()) break;
                }else{
                    if(Math.random()>0.75) // with acknowledgement errors
                    Medium.ack.set(connectionNumber, seq_num);
                }
            }
            for(int i=0;i<size;i++){
                final_data+=map.get(i);
            }
            System.out.println("----Data transmission completed, Data is: "+final_data);
            System.out.println("---------------------------------------------------------------");
        }
    }
}
