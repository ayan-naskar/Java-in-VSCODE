import java.net.*;
public class MulticastPublisher {
  private DatagramSocket socket;
  private InetAddress group;
  private byte[] buf;
  
  public void multicast(String multicastMessage) throws Exception {
    socket = new DatagramSocket();
    group = InetAddress.getByName("230.0.0.0");
    buf = multicastMessage.getBytes();
    
    DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
    Thread.sleep(10000);
    socket.send(packet);
    socket.close();
  }
  public static void main(String Args[]){
    try{
      MulticastPublisher m=new MulticastPublisher();
      m.multicast("HELLO");
      m.multicast("end");
    }catch (Exception e){System.out.println("fg");}
  }  
}