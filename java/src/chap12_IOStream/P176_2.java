package chap12_IOStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class P176_2 {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("c:/users/campus2H032/desktop/test1.txt");
        os.write((byte)10 );
        os.write((byte)20);
        os.write((byte)30);
        os.flush();
        os.close();
    }
}
