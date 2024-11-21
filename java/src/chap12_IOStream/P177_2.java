package chap12_IOStream;

import java.io.*;

public class P177_2 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("c:/users/campus2H032/desktop/test1.txt");
        int data;
        while((data=is.read())!=-1){
            System.out.println(data);
        }
        is.close();

    }
}