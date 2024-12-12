// Java 프로그래밍 - 예외 처리

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


// 사용자가 정의한 예외
class NotTenException extends RuntimeException {}

public class Main {

    // 10이 아니면 false 리턴, 10이면 true를 리턴하는 함수.
    public static boolean checkTen(int ten) {
        if (ten != 10) {
            return false;
        }

        return true;
    }

    // 사용자가 정의한 예외 출력시켜보기, 메소드안에서 예외 처리
    public static boolean checkTenWithException(int ten) {
        try {
            if (ten != 10) {
                throw new NotTenException();
            }
        } catch (NotTenException e) {
            System.out.println("e = " + e);
            return false;
        }
//        if (ten != 10) {
//            throw new NotTenException();
//        }
        return true;
    }

    // throws는 예외를 이부분에서 처리하는게 아니라 다른곳으로 전달시킴.
    // checkTenWithThrows를 호출한 쪽에서 처리해주면 됨.
    public static boolean checkTenWithThrows(int ten) throws NotTenException{
        if (ten != 10) {
            throw new NotTenException(); // 예외 발생하면 여기서 처리하는게 아니라 throws로 밖에 보냄
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

//      1. 예외
//      1-1. 0으로 나누기
        System.out.println("== 0으로 나누기 ==");
//        int a = 5 / 0;

        try {
            int a = 5 / 0; // 0d=으로 나누는 예외 발생 아래 캐치문에 걸림.
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누기 예외 발생");
            System.out.println("e = " + e); // 이후 프로그램이 종료되지 않고 계속 실행.
        } finally { // 예외가 발생하든 안하든 무조건 실행
            System.out.println("1-1 연습 종료");
        }

//      1-2. 배열 인덱스 초과
        System.out.println("== 배열 인덱스 초과 ==");
        int[] b = new int[4];
//        b[4] = 1;

        try {
            b[4] = 1;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("e = " + e);
        }

//      1-3. 없는 파일 열기
        System.out.println("== 없는 파일 열기 ==");
//        BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
        try {
            BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("e = " + e);
        }


//      2. throw, throws
        System.out.println("== checkTen ==");
        boolean checkResult = Main.checkTen(10);
        System.out.println("checkResult = " + checkResult);

//        Throw는 우리가 예외를 발생시켜봄
        System.out.println("== checkTenWithException ==");
        checkResult = Main.checkTenWithException(9); // 10이 아닌 숫자를 넣으면 예외 발생!
        System.out.println("chechResult = " + checkResult);

        System.out.println("== checkTenWithThrows ==");

        try {
            checkResult = checkTenWithThrows(5);
        } catch (NotTenException e) {
            System.out.println("e = " + e);
        }
        System.out.println("checkResult = " + checkResult);
        // 예외 처리하고 false를 출력함.


    }

}
