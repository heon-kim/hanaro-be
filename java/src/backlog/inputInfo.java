package backlog;

import java.util.Scanner;

public class inputInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String name = scanner.next();
        System.out.println("Enter Your Address: ");
        String addr = scanner.next();
        System.out.println("Enter Your Age: ");
        int age = scanner.nextInt();
        System.out.println("Enter Your Height: ");
        double height = scanner.nextDouble();

        System.out.println("안녕하세요."+name+"님, "+addr+age+height);
    }

}
