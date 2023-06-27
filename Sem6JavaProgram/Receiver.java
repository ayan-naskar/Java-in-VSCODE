public class Receiver implements Runnable{
    public void run() {
        int numberOfConnections = 0;

        while(true){
            int currConnections = Medium.sequenceNumber.size();
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
            int currSeqNumber = 0;
            String final_data="";
            while(true) {
                try {Thread.sleep(133);} 
                catch (InterruptedException e) {e.printStackTrace();}
                int seq_num = Medium.sequenceNumber.get(connectionNumber);
                if(seq_num == currSeqNumber) {
                    String data = Medium.data.get(connectionNumber);
                    System.out.println("----Data received: "+data+",  for Connection Number: "+connectionNumber);

                    // if(Math.random()>0.75) // with acknowledgement errors
                    Medium.ack.set(connectionNumber, currSeqNumber);
                    currSeqNumber++;
                    if(data.equals("%")) break;
                    final_data+=data;
                }
            }
            System.out.println("----Data transmission completed, Data is: "+final_data);
            System.out.println("---------------------------------------------------------------");
        }
    }
}
