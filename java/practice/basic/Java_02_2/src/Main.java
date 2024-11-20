// Java 프로그래밍 - 변수와 자료형_2

public class Main {
    public static void main(String[] args) {

//      1. 자료형 - 숫자
        System.out.println("== 숫자 ==");
//      1-1. 정수
        int intNum = 10;
        System.out.println("intNum = " + intNum);

        // 변경되지 않는 상수값 대문자 스네이크 표기. 정수의 최대 최솟값 출력
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Integer.MAX_VALUE); // 2147483647

        // 최댓값을 넘는 수를 변수에 할당해보기
        int intNum2 = Integer.MAX_VALUE;
        System.out.println("intNum2 = " + intNum2); // 2147483647
        int intNum3 = Integer.MAX_VALUE + 1;
        System.out.println("IntNum3 = " + intNum3); //-2147483648
        // Maximum 데이터를 넘어가서 다시 최솟값으로 넘어감. 잘못된 데이터가 출력됨.

        // int 타입보다 더 큰 숫자를 담기 위해서는 long 타입을 사용하면 됨.
//      long longNum = Integer.MAX_VALUE + 1; 변수에 int의 값에서 1을 더한 상태로 할당됨.
        // 자료형변환 = 앞에 괄호를 붙여주기
        long longNum = (long)Integer.MAX_VALUE + 1;
        System.out.println("longNum = " + longNum); // 2147483648

//      1-2. 실수
        // 숫자 뒤에 f를 붙여줘야 float형 자료로 인식함. 안 써주면 double이다.
        float floatNum = 1.23f;
        double doubleNum = 1.23;
        System.out.println(Float.MAX_VALUE);    // 3.4028235E38 (E38은 10의 38승이라는 뜻)
        System.out.println(Double.MAX_VALUE);   // 1.7976931348623157E308

//      1-3. 2진수 / 8진수 / 16진수
        // 출력은 전부 10진수 12로 출력됨.
        int numBase2 = 0b1100;
        System.out.println("numBase2 = " + numBase2);
        int numBase8 = 014;
        System.out.println("numBase8 = " + numBase8);
        int numBase16 = 0xC;
        System.out.println("numBase16 = " + numBase16);

        // 원래 포맷으로 출력하는 법
        System.out.println("0b" + Integer.toBinaryString(numBase2));    // 0b1100
        System.out.println("0" + Integer.toOctalString(numBase8));      // 014
        System.out.println("0x" + Integer.toHexString(numBase16));      // 0xc

//      2. 자료형 - 부울
        System.out.println("== 부울 ==");
        boolean isPass = true;
        System.out.println("isPass = " + isPass);   // isPass = true
        boolean isOk = false;
        System.out.println("isOk = " + isOk);       // isOk = false


//      3. 자료형 - 문자
        System.out.println("== 문자 ==");
        char keyFirst = 'a';
        System.out.println("keyFirst = " + keyFirst);
        char keyLast = 'z';
        System.out.println("keyLast = " + keyLast);
        System.out.println((int)keyFirst); // 97 -> 아스키코드. 각각의 문자가 코드값이 매핑되어있다.
        System.out.println((int)keyLast); // 122


    }
}
