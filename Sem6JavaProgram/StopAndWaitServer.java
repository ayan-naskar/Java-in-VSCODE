import java.net.*;
import java.io.*;

public class StopAndWaitServer {
    
    public static void main(String[] args) throws Exception {
        
        // Open a server socket for accepting connections
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("Server is running.");
        
        // Accept a client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");
        
        // Create input and output streams for sending and receiving data
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        
        // Receive data from the client using Stop-and-Wait protocol
        int expectedSequenceNumber = 0;
        while(true) {
            // Wait for a message from the client
            String packet = bufferedReader.readLine();
            System.out.println("Received: " + packet);
            
            // Extract the sequence number and message from the packet
            String[] parts = packet.split(":");
            int sequenceNumber = Integer.parseInt(parts[0]);
            String message = parts[1];
            
            Thread.sleep(1000);
            
            // Send an ACK to the client for the received message
            if(sequenceNumber == expectedSequenceNumber) {
                String ack = Integer.toString(sequenceNumber);
                printWriter.println(ack);
                System.out.println("Sent: " + ack);
                expectedSequenceNumber = 1 - expectedSequenceNumber; // Switch the expected sequence number
            }
            Thread.sleep(500);
            
            if(parts[1].equals("0")) break;
        }
    }
    
}