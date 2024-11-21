package chap12_IOStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class P187_1 {
    static class Account{
        String id;
        String name;
        int balance = 0;

        Account(String id, String name, int balance){
            this.id = id;
            this.name = name;
            this.balance = balance;
        }
        @Override
        public String toString(){
            return "Account[id="+id+", name="+name+", balance="+balance+"]";
        }

        public static void main(String[] args) {
            Account a1 = new Account("1111", "conan", 10000);
            Account a2 = new Account("2222", "rose", 20000);
            File file = new File("account.txt");

            try(PrintWriter pw = new PrintWriter(new FileWriter(file))){
                pw.println(a1);
                pw.println(a2);
            }catch(IOException e){
                e.printStackTrace();
            }
        }


    }

}
