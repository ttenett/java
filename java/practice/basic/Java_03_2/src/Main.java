// Java 프로그래밍 - 여러가지 연산자_2

public class Main {
    public static void main(String[] args) {

//      1. 비트 논리 연산자
        System.out.println("== 비트 논리 연산자 ==");
//      1-1. AND 연산자 (&)
        System.out.println("== & ==");
        int num1 = 5;
        int num2 = 3;
        int result = 0;

        result = num1 & num2;
        System.out.println("result = " + result);           // result = 1
        System.out.println(Integer.toBinaryString(num1));   // 101
        // println - 기본 출력에 ln이라는 라인넘김(엔터) 추가
        // printf는 데이터 포맷을 만들어 그 포맷에 맞게 데이터값 넣어 출력 할 수 있게 해주는 출력문.
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));    // 0101
        // 04 : 4개자릿수 출력, 자릿수 못채우면 앞에 0 넣기. %d는 서식문자(정수형 데이터 받을 수 있음)
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));    // 0011
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));  // 0001


//      1-2. OR 연산자 (|)
        System.out.println("== | ==");

        result = num1 | num2;
        System.out.println("result = " + result);    // result = 7
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));    // 0101
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));    // 0011
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));  // 0111


//      1-3. XOR 연산자 (^)
        System.out.println("== XOR ==");
        
        result = num1 ^ num2;
        System.out.println("result = " + result);   // result = 6
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));    // 0101
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));    // 0011
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));  // 0110


//      1-4. 반전 연산자 (~)
        System.out.println("== ~ ==");

        num1 = 5; // 보기 편하게 다시 작성.
        result = ~num1;
        System.out.println("result = " + result);   // result = -6
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));    // 0101
        System.out.printf("%s\n", Integer.toBinaryString(result)); // 11111111111111111111111111111010
        // 0101이 반전이 되어 끝 네자리가 1010이 되고, 앞 부호비트가 전부 1로 변경됨. 바이트 체계가 32개.


//      2. 비트 이동 연산자
        System.out.println("== 비트 이동 연산자 ==");
//      2-1. << 연산자
        int numA = 3;
        result = numA << 1;

        System.out.println("result = " + result);   // result = 6
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA)));    // 0011
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));  // 0110


//      2-2. >> 연산자
        result = numA >> 1;
        System.out.println("result = " + result);   // result = 1
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA)));    // 0011
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));  // 0001


//      2-3. >>> 연산자
        numA = -5;
        result = numA >> 1;
        System.out.printf("%s\n", Integer.toBinaryString(numA));    // 11111111111111111111111111111011
        System.out.printf("%s\n", Integer.toBinaryString(result));  // 11111111111111111111111111111101 >> -5에서 1자리 밀림

        result = numA >>> 1;
        System.out.printf("%s\n", Integer.toBinaryString(numA));    // 11111111111111111111111111111011
        System.out.printf("%s\n", Integer.toBinaryString(result));  // 1111111111111111111111111111101  >>> 가장 앞 빈비트 0으로 채워줌(생략)


    }

}
