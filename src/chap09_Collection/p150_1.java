package chap09_Collection;

import java.util.HashMap;
import java.util.Scanner;

public class p150_1 {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();

        dictionary.put("apple", "사과");
        dictionary.put("love", "사랑");
        dictionary.put("baby", "아기");
        dictionary.put("hello", "안녕하세요");
        dictionary.put("world", "세계");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("찾고 싶은 단어는?");
            String word = scanner.nextLine();
            System.out.println(dictionary.get(word));
        }
    }
}
