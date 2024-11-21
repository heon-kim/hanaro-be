package chap12_network;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class EchoThread extends Thread{
    private Socket socketOfServer;
    public EchoThread(Socket socketOfServer){
        this.socketOfServer = socketOfServer;
    }
    @Override
    public void run(){
        try{
            InetAddress inetaddr = socketOfServer.getInetAddress();
            System.out.println(inetaddr.getHostAddress()+"로부터 접속하였습니다.");
            OutputStream out=socketOfServer.getOutputStream();
            InputStream in = socketOfServer.getInputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out),true);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while((line = br.readLine())!=null){
                System.out.println("클라이언트로부터 전송받은 문자열:"+line);
                pw.println(line);
            }
            pw.close();
            br.close();
            socketOfServer.close();
        }catch(IOException e){
            
        }
    }
}

public class P205 {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(9999);
            System.out.println("접속을 기다립니다.");
            while(true){
                Socket socketOfServer = server.accept();
                EchoThread echoThread = new EchoThread(socketOfServer);
                echoThread.start();
            }
        }catch (IOException e){
            
        }
    }
}
