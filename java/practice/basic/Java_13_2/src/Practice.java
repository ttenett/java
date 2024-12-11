// Practice
// JamesArthurGosling.txt 파일을 읽은 후 원하는 단어 변경하여 새로 저장해보자.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws IOException {
        String inputFile = "D:/BE/java/practice/Java_13_2/JamesArthurGosling.txt";
        String outputFile = "D:/BE/java/practice/Java_13_2/JamesArthurGosling_edit.txt";


        // 찾을 단어 / 변경 단어 입력 받기
        System.out.print("찾을 단어: ");
        Scanner sc = new Scanner(System.in);
        String find = sc.nextLine();
        System.out.print("변경 단어: ");
        String to = sc.nextLine();

        // 파일 읽기, 변경 및 저장
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        FileWriter fw = new FileWriter(outputFile);

        while (true) {
            // 한줄씩 읽음
            String line = br.readLine();
            if (line == null) {
                break;
            }

            // 찾을 단어 있으면 변경 (찾을 단어, 바꿀 단어)
            String newLine = line.replace(find, to);
            // 저장
            fw.write(newLine + '\n');
        }

        br.close();
        fw.close();


    }
}

// 찾을 단어 / 변경 단어 입력 받기 내가 쓴 답 ㅠㅜ
//        BufferedReader word = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("입력: ");
//        String searched = word.readLine();
//        System.out.println("찾은 단어: " + searched);
//
//        // 파일 읽기, 변경 및 저장
//        BufferedReader rd = new BufferedReader(new FileReader("./JamesArthurGosling.txt"));
//
//        while (true) {
//            String line = rd.readLine();
//
//            if (line == null) {
//                break;
//            }
//            System.out.println(line);
//        }
//        rd.close();