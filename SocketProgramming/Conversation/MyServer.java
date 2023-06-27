import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        int ch = 1;
        Scanner sc = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(123);
            System.out.println("Waiting for Client");
            Socket s = ss.accept();
            System.out.println("Connection Accepted");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            loop: while(true) {
                switch(ch) {
                    case 1:
                        String str = (String) dis.readUTF();
                        System.out.println("Message from Client = "+str);                        
                        if(str.equals("over")){
                            System.out.println("SERVER START SENDING MESSAGE:");
                            ch = 2;
                        }else if(str.equals("over and out")){
                            System.out.println("CONVERSATION ENDED");
                            ch = 3;
                        }
                        break;

                    case 2:
                        String st = sc.nextLine();
                        dout.writeUTF(st);
                        if(st.equals("over")){ 
                            System.out.println("MESSAGES FROM CLIENT:");
                            ch = 1;
                        }
                        else if(st.equals("over and out")){ 
                            System.out.println("CONVERSATION ENDED");
                            ch = 3;
                        }
                        dout.flush();
                        break;

                    default: 
                        break loop;
                }
            }
            ss.close();
            dout.close();
            dis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}