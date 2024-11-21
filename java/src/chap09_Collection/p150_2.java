package chap09_Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p150_2 {
    static class Student {
        String name;
        int id;
        String phoneNo;

        Student(String name, int id, String phoneNo) {
            this.name = name;
            this.id = id;
            this.phoneNo = phoneNo;
        }

        @Override
        public String toString() {
            return this.name + "(" + this.id + ") : " + this.phoneNo;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int count = 4;

        for (int i = 0; i < count; i++) {
            System.out.println("이름, 아이디, 전화번호 순으로 입력하시오.");
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String phoneNo = tokens[2];
            students.put(name, new Student(name, id, phoneNo));
        }

        for(Map.Entry<String, Student> m:students.entrySet()){
            System.out.println(m.getValue());
        }

        scanner.close();
    }
}
