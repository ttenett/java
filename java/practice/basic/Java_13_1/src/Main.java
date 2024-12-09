// Java 프로그래밍 - 입출력_1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void referInputStream() throws IOException {
//      콘솔로 입력받기
//      System.in
        System.out.println("== System.in ==");
//        System.out.print("입력 :");
////      캐릭터 값 하나를 받아올 수 있음. 숫자값을 받아오면 아스키코드값에 매핑. 그값만큼 빼서 숫자로 변환해줌.
//        int a = System.in.read() - '0';
//        System.out.println("a = " + a);
////      in.read는 입력스트림에서 하나만 가져올 수 있다. 뒤에 엔터키가 남게 되는데 그 부분을 소진해서 없애줘야함.
////      입력스트림에 남아 있는 만큼 바이트 형태로 읽어서 그 데이터를 소진시켜 줌.
//        System.in.read(new byte[System.in.available()]); // 입력값이 나오고, 여러값을 넣어도 하나만 나옴.
//
//      InputStreamReader - 읽고자 하는 개수만큼 배열을 만들어주고 읽어야 함.
        System.out.println("== InputStreamReader ==");
//      InputStreamReader 객체 만들때 매개변수로 System.in을 넣어줘야 함.
//      여러개의 데이터를 받아 올 수 있다. 그 값을 받아오기 위한 배열이 필요.
        InputStreamReader reader = new InputStreamReader(System.in);
        char[] c = new char[3];
        System.out.print("입력: ");
        reader.read(c); // 17번째 줄이 없으면 여기에 엔터키가 남아 여기서 이상한 값이 나옴.
        System.out.println(c); // 배열 개수만큼 나옴.


//      BufferedReader - 원하는 개수만큼 자유자재로 읽어들일 수 있다.
        System.out.println("== BufferedReader ==");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("입력: ");
        String s1 = br.readLine();
        System.out.println("s1 = " + s1);

    }

    public static void main(String[] args) throws IOException {

//      1. 입력
//      1-1. 다른 입력 방식 참고
//        referInputStream();

//      1-2. Scanner
        System.out.println("== Scanner ==");
        Scanner sc = new Scanner(System.in);
//        System.out.print("입력1: ");
//        System.out.println(sc.next());
//        sc.nextLine(); // 엔터키 소진
//
//        System.out.print("입력2: ");
//        System.out.println(sc.nextInt()); // 정수 외 값 입력하면 오류남.
//        sc.nextLine();

//        System.out.print("입력3: ");
//        System.out.println(sc.nextLine());


//      참고) 정수, 문자열 변환
        int num = Integer.parseInt("12345");    // 문자열이 int형으로 변환되어 반환.
        String str = Integer.toString(12345);   // 숫자값이 문자로 바뀌어 반환

        
//      2. 출력
        System.out.println("== 출력 ==");
        System.out.println("Hello");
        System.out.println("World!");

        System.out.print("Hello");
        System.out.print("World!");
        System.out.println();

        //printf 포맷을 지정한 다음 맞춰서 출력, 포맷이 없으면 print와 동일하게 출력
        System.out.printf("Hello");
        System.out.printf("world!");
        System.out.println();

        String s = "자바";
        int number = 3;

        // 서식 문자
        System.out.println(s + "는 언어 선호도 " + number +"위 입니다.");
        System.out.printf("%s는 언어 선호도 %d위 입니다.\n", s, number);

        // 정수형, 8진수, 16진수
        System.out.printf("%d\n", 10);
        System.out.printf("%o\n", 10);
        System.out.printf("%x\n", 10);

        // 실수형
        System.out.printf("%f\n", 5.2f);

        // 문자형
        System.out.printf("%c\n", 'A');
        System.out.printf("%s\n", "안녕하세요");

        // 줄맞춤 또는 공백맞추기 - 왼쪽 정렬은 %다음 -붙이기
        System.out.printf("%5d\n", 123); // 5개 공간 확보 후 오른쪽에 숫자 넣기
        System.out.printf("%5d\n", 1234);
        System.out.printf("%5d\n", 12345);

        System.out.printf("%-5d\n", 123);
        System.out.printf("%-5d\n", 1234);
        System.out.printf("%-5d\n", 12345);

        // 소숫점 자리수 (반올림 되어 출력)
        System.out.printf("%.2f\n", 1.1264123f); // 소수점 2번째 자리까지만 나옴.



    }
}
