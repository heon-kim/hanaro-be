package chap12_IOStream;

import java.io.File;

public class P185 {
    public static void main(String[] args) {
        File file = new File("c:/users/campus2H032/desktop");
        File[] fs = file.listFiles();
        for(File f:fs)
            if(f.isDirectory())
                System.out.printf("dir:%s\n",f);
            else{
                System.out.printf("file: %s(%d bytes)\n", f, f.length());
            }
        String res;
    }
}
