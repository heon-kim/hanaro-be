package chap9_Collection;

import java.util.HashMap;
import java.util.Map;

public class p148 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "바나나");
        map.put(2, "사과");
        map.put(3, "오렌지");
        System.out.println("----------------------------------");
        for (Map.Entry m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println("----------------------------------");
        map.put(3, "오렌지");
        for (Map.Entry m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println("----------------------------------");
        map.remove(3);
        for (Map.Entry m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
