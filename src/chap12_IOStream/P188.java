package chap12_IOStream;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Member {
    String name;
    String phoneNo;
    String address;

    Member(String name, String phoneNo, String address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.phoneNo + " " + this.address;
    }
}

public class P188 {
    private static List<Member> memberList = new ArrayList<>();
    static File file = new File("c:/users/campus2H032/desktop/memberList.txt");

    public static void main(String[] args) {
        loadMemberList();  // 프로그램 시작 시 기존 파일을 불러와 목록에 추가
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printWelcomeMessage();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1->addMember(scanner);
                case 2->showMember(scanner);
                case 3->removeMember(scanner);
                case 4->showMemberList();
                case 5->saveMemberList();
                case 6->{
                    System.out.println("종료");
                    return;
                }
                default->System.out.println("올바른 메뉴 번호를 선택해주세요.");
            }
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("==================================================================================");
        System.out.println("1. 전화번호 추가 2. 전화번호 조회 3. 전화번호 삭제 4. 전화번호 목록 5. 연락처 파일로 저장 6. 종료");
        System.out.println("==================================================================================");
        System.out.print("메뉴를 선택하세요>> ");
    }

    private static void addMember(Scanner scanner) {
        System.out.println("이름, 전화번호, 주소 순으로 입력하세요.");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        memberList.add(new Member(data[0], data[1], data[2]));
    }

    private static void showMember(Scanner scanner) {
        System.out.println("조회할 회원의 이름을 입력하세요>> ");
        String name = scanner.nextLine().trim();
        if (memberList.contains(name)) {
            for (Member member : memberList) {
                if (Objects.equals(member.getName(), name)) {
                    System.out.println(member);
                }
            }
        } else {
            System.out.println("존재하지 않는 회원입니다.");
        }
    }

    private static void removeMember(Scanner scanner) {
        System.out.println("삭제할 회원의 이름을 입력하세요>> ");
        String name = scanner.nextLine().trim();
        if (memberList.contains(name)) {
            memberList.removeIf(member -> Objects.equals(member.getName(), name));
            System.out.println("해당 멤버를 삭제했습니다.");
        } else {
            System.out.println("존재하지 않는 회원입니다.");
        }
    }

    private static void showMemberList() {
        System.out.println("목록에 저장된 회원 수는 " + memberList.size() + "명 입니다.");
        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    private static void saveMemberList() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Member member : memberList) {
                pw.println(member);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadMemberList() {
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(" ");
                    if (data.length == 3) {
                        memberList.add(new Member(data[0], data[1], data[2]));
                    }
                }
                System.out.println("기존 전화번호 목록을 불러왔습니다.");
            } catch (IOException e) {
                System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            }
        } else {
            System.out.println("기존 전화번호 목록 파일이 없습니다.");
        }
    }
}
