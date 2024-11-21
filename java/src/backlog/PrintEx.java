package backlog;

public class PrintEx {
    public static void main(String[] args){
        String name = "코난";
        int age = 10;
        double height = 80.5;
        System.out.println("---------------");
        System.out.println("내 이름은 "+name);
        System.out.println("나이는 "+age+"살");
        System.out.println("키는 "+height+"cm");
        System.out.println("---------------");
        System.out.printf("내 이름은 %s\n 나이는 %d살\n 키는 %fcm\n", name,age,height);
        System.out.println("---------------");
    }
}
