import java.net.*;
import java.io.*;

public class StopAndWaitClient {
    
    public static void main(String[] args) throws Exception {
        
        // Open a socket for communication
        Socket socket = new Socket("localhost", 8081);
        System.out.println("Connected to server.");
        
        // Create input and output streams for sending and receiving data
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        
        // Send data to the server using Stop-and-Wait protocol
        int sequenceNumber = 0;
        boolean ackReceived = false;
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        do{
            String message=bf.readLine();
            // Send the message with the current sequence number
            String packet = sequenceNumber + ":" + message;
            printWriter.println(packet);
            System.out.println("Sent: " + packet);
            
            // Wait for the ACK from the server
            String ack = bufferedReader.readLine();
            System.out.println("Received: " + ack);
            
            // Check if the ACK is for the current sequence number
            if(ack.equals(Integer.toString(sequenceNumber))) {
                ackReceived = true;
                sequenceNumber = 1 - sequenceNumber; // Switch the sequence number
            }
            if(message.equals("0")) break;
        }while(!(ackReceived=!ackReceived));
        
        // Close the socket and streams
        bufferedReader.close();
        printWriter.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
    
}