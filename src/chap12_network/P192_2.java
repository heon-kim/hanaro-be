package chap12_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class P192_2 {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://en.wikipedia.org");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while((inputLine=in.readLine())!=null)
                System.out.println(inputLine);
            in.close();
        }catch (IOException e){
            System.out.println("URL에서 데이터 읽는 중");
        }
    }
}
