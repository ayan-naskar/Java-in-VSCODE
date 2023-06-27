import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(123);
            System.out.println("Waiting for Client");
            Socket s = ss.accept();
            System.out.println("Connection Accepted");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("Message from Client = "+str);
            ss.close();
        } catch(IOException e) {
            System.out.print(e);
        }
    }
}