package backlog;

import java.util.Scanner;

public class LibraryProgram {
    private static Book[] books = new Book[10];
    private static int bookCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== 도서관 프로그램 ===");
            System.out.println("1. 도서정보입력");
            System.out.println("2. 도서 목록 보기");
            System.out.println("3. 검색하기(제목)");
            System.out.println("4. 수량정보(여성작가수량/보유도서수량)");
            System.out.println("5. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 줄바꿈 문자 제거

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    searchBookByTitle();
                    break;
                case 4:
                    displayQuantityInfo();
                    break;
                case 5:
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void addBook() {
        if (bookCount >= books.length) {
            System.out.println("더 이상 도서를 추가할 수 없습니다.");
            return;
        }

        System.out.println("도서정보를 입력하세요 (예: 제목 저자 이메일 성별(M/F) 가격 수량): ");
        String input = scanner.nextLine();
        String[] bookData = input.split(" ");

        if (bookData.length != 6) {
            System.out.println("잘못된 입력 형식입니다.");
            return;
        }

        try {
            String title = bookData[0];
            String authorName = bookData[1];
            String email = bookData[2];
            char gender = bookData[3].charAt(0);
            double price = Double.parseDouble(bookData[4]);
            int qty = Integer.parseInt(bookData[5]);

            Author author = new Author(authorName, email, gender);
            Book book = new Book(title, author, price, qty);
            books[bookCount++] = book;
            System.out.println("도서가 성공적으로 추가되었습니다.");
        } catch (Exception e) {
            System.out.println("입력 오류가 발생했습니다. 다시 시도해주세요.");
        }
    }

    private static void displayAllBooks() {
        System.out.println("=== 도서 목록 ===");
        if (bookCount == 0) {
            System.out.println("등록된 도서가 없습니다.");
        } else {
            for (int i = 0; i < bookCount; i++) {
                System.out.println(books[i]);
            }
        }
    }

    private static void searchBookByTitle() {
        System.out.print("검색할 도서 제목을 입력하세요: ");
        String title = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println(books[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("해당 제목의 도서를 찾을 수 없습니다.");
        }
    }

    private static void displayQuantityInfo() {
        int femaleAuthorQty = 0;
        int totalQty = 0;

        for (int i = 0; i < bookCount; i++) {
            totalQty += books[i].getQty();
            if (books[i].getAuthor().getGender() == 'F' || books[i].getAuthor().getGender() == 'f') {
                femaleAuthorQty += books[i].getQty();
            }
        }

        System.out.println("여성 작가의 도서 수량: " + femaleAuthorQty);
        System.out.println("전체 보유 도서 수량: " + totalQty);
    }
}

// backlog.Author 클래스
class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    @Override
    public String toString() {
        return "backlog.Author{name='" + name + "', email='" + email + "', gender=" + gender + "}";
    }
}

// backlog.Book 클래스
class Book {
    private String title;
    private Author author;
    private double price;
    private int qty;

    public Book(String title, Author author, double price, int qty) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    @Override
    public String toString() {
        return "backlog.Book{title='" + title + "', author=" + author + ", price=" + price + ", qty=" + qty + "}";
    }
}
