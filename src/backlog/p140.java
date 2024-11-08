package backlog;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p140 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();

        long startTime, endTime;
        DecimalFormat df = new DecimalFormat("#,###.0");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("ArrayList에 데이터 저장하는데 걸린 시간: %snsec\n", df.format(endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("LinkedList에 데이터 저장하는데 걸린 시간: %snsec\n", df.format(endTime - startTime));
    }

}
