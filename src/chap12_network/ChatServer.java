package chap12_network;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedReader stin = null;
        PrintWriter out = null;
        ServerSocket server = null;
        Socket socketOfServer = null;

        try{
            server = new ServerSocket(9999);
            socketOfServer = server.accept();
            System.out.println("연결됨");
            in = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            stin = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            String inputMessage;
            while(true){
                inputMessage = in.readLine();
                if(inputMessage.equalsIgnoreCase("bye"))
                    break;
                System.out.println(inputMessage);
                String outputMessage = stin.readLine();
                out.println("서버>"+outputMessage);
                out.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try{
                socketOfServer.close();
                server.close();
            }catch (IOException e){

            }
        }
    }

}
