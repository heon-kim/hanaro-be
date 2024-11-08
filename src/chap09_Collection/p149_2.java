package chap09_Collection;

import java.util.HashMap;
import java.util.Map;

public class p149_2 {
    static class Book {
        int id;
        String title;
        String author;
        int quantity;

        Book(int id, String title, String author, int quantity){
            this.id = id;
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }
    }
    public static void main(String[] args) {
        HashMap<Integer, Book> map = new HashMap<Integer,Book>();
        map.put(1, new Book(100, "어린왕자", "쌩땍쥐베리", 5));
        map.put(2, new Book(200, "행복한왕자", "오스카와일드", 10));
        map.put(3, new Book(300, "셜록홈즈", "코난도일", 8));
        for(Map.Entry <Integer,Book> entry: map.entrySet()){
            int key = entry.getKey();
            Book book = entry.getValue();
            System.out.println(key+"의 세부 항목");
            System.out.printf("%d %s %s %d\n", book.id, book.title, book.author, book.quantity);
            System.out.println("--------------------------------");
        }

    }
}
