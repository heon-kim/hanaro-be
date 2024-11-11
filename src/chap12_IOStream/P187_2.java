package chap12_IOStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P187_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "c:/users/campus2H032/desktop/강의자료/dorian.txt";

        while (true) {
            System.out.print("찾고싶은 단어는 무엇입니까? ");
            String wordToFind = scanner.nextLine().toLowerCase();

            int count = 0;

            // 파일에서 단어 검색
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // 구두점과 공백을 기준으로 문자열을 나눔
                    String[] words = line.toLowerCase().split("[\\s.,\"\'!?]+");
                    for (String word : words) {
                        if (word.equals(wordToFind)) {
                            count++;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                continue;
            }
            if(count == 0){
                System.out.println("한번도 사용한적 없음");
            }else {
                System.out.println(count + "번 사용됨");
            }

        }
    }
}
