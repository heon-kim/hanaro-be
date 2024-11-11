package chap12_IOStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class P178 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("c:/users/campus2H032/desktop/test1.txt");
        byte[] buffer = new byte[100];
        int count;
        while((count = is.read(buffer))!= -1)
            for(int i=0; i<count;i++){
                System.out.println((buffer[i]));
        }
    }
}
