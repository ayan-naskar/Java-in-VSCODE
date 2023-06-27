import java.io.*;  
import java.net.*; 
class BroadcastingClient {
  private static DatagramSocket socket = null;
  public static void broadcast(String broadcastMessage, InetAddress address) throws IOException {
    socket = new DatagramSocket();
    socket.setBroadcast(true);
    
    byte[] buffer = broadcastMessage.getBytes();
    
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4446);
    socket.send(packet);
    socket.close();
  }
  
  public static void main(String[] args) throws IOException {
    broadcast("Hello", InetAddress.getByName("193.168.2.255"));
    broadcast("bye", InetAddress.getByName("255.255.255.255"));
  } 
  
}