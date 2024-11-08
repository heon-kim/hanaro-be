package chap09_Collection;

import java.util.HashSet;



public class p145_2 {
    static class Book {
        int id;
        String title;
        String author;
        int quantity;

        public Book(int id, String title, String author, int quantity){
            this.id=id;
            this.title=title;
            this.author=author;
            this.quantity=quantity;
        }
    }
    public static void main(String[] args) {
        HashSet<Book> set = new HashSet<Book>();
        set.add(new Book(100, "어린왕자", "쌩떽쥐베리",5));
        set.add(new Book(200, "행복한왕자", "오스카와일드",5));
        set.add(new Book(300, "셜록홈즈", "코난도일",5));
        for(Book book: set){
            System.out.printf("%d %s %s %d\n", book.id, book.title, book.author, book.quantity);
        }
    }
}
