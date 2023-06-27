import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        int ch = 2;
        try{
            Socket s=new Socket("127.0.0.1",123);
            System.out.println("Connected");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            loop: while(true) {                
                switch(ch) {
                    case 1:
                        String str = (String) dis.readUTF();
                        System.out.println("Message from Server = "+str);
                        if(str.equals("over")){
                            System.out.println("CLIENT START SENDING MESSAGE:");
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
                            System.out.println("MESSAGES FROM SERVER:");
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
            s.close();
            dout.close();
        }catch(IOException e){
            System.out.println(e);
        }
        sc.close();
    }
}