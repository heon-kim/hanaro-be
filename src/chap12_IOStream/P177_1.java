package chap12_IOStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class P177_1 {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("d:/users/campus2H032/desktop/test2.txt");
        byte[] bArray1 = {10,20,30};
        os.write(bArray1);
        os.flush();
        os.close();

        os = new FileOutputStream("c:/users/campus2H032/desktop/test2.txt");
        byte[] bArray2 = {10,20,30,40,50};
        os.flush();
        os.close();
    }
}