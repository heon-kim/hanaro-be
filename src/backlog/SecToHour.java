package backlog;

import java.util.Scanner;

public class SecToHour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시간을 초단위로 입력하세요: ");
        int sec  = sc.nextInt();
        int second = sec%60;
        sec = sec/60;
        int minute = sec%60;
        sec = sec/60;
        int hour = sec%60;
        System.out.println(hour+":"+minute+":"+second);

    }
}
