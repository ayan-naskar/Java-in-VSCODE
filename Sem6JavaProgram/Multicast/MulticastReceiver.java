import java.net.*;
public class MulticastReceiver extends Thread {
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
    
    public void run(){
        try{ socket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println(received);
                if ("end".equals(received)) {
                    break;
                }
            }socket.leaveGroup(group);
            socket.close();
        }catch (Exception E){System.out.println("sss");}
        
    }
    public static void main(String Args[]){
        Thread t=new Thread(new MulticastReceiver());
        t.start();
        t=new Thread(new MulticastReceiver());
        t.start();
        t=new Thread(new MulticastReceiver());
        t.start();
    }
}