// Java 프로그래밍 - 여러가지 연산자_1

public class Main {
    public static void main(String[] args) {

//      1. 대입 연산, 부호 연산자
        int num = 100;
        num = +10;
        num = 10;
        num = -10;

//      2. 산술 연산자, 증가/감소 연산자
        System.out.println("== 산술 연산자, 증가/감소 연산자 ==");
        int numX = 10;
        int numY = 3;
        int result = 0;
        result = numX + numY;
        result = numX - numY;
        result = numX * numY;
        result = numX / numY;
        result = numX % numY;
        System.out.println("result = " + result);

        int numZ = 1;
        System.out.println(numZ++); // 1, 원래 값 사용 후 증가시킬게
        System.out.println(numZ);   // 2

        numZ = 1;
        System.out.println(++numZ); // 2
        System.out.println(numZ);   // 2

        numZ = 1;
        System.out.println(numZ--); // 1
        System.out.println(numZ);   // 0

        numZ = 1;
        System.out.println(--numZ); // 0
        System.out.println(numZ);   // 0


//      3. 관계 연산자
        System.out.println("== 관계 연산자 ==");
        int numA = 10;
        int numB = 9;

        System.out.println(numA > numB);    // true
        System.out.println(numA < numB);    // false
        System.out.println(numA == numB);   // false
        System.out.println(numA != numB);   // true


//      4. 논리 연산자
        System.out.println("== 논리 연산자 ==");
        System.out.println((10 > 9) && (1 == 0)); // false
        System.out.println((10 > 9) || (1 == 0)); // true


//      5. 복합 대입 연산자
        System.out.println("== 복합 대입 연산자 ==");
        int num1 = 10;
        int num2 = 5;
        num1 += num2;
        System.out.println("num1 = " + num1); // num1 = 15
        num1 -= num2;
        num1 *= num2;

//      6. 삼항 연산자
        System.out.println("== 삼항 연산자 ==");
        // ?를 기준으로 좌측값이 참이면, ':'콜론 사이로 좌측값 사용. 거짓이면 ':'의 우측값 사용.
        int a = 100;
        String aResult = (a == 100) ? "yes":"no";
        System.out.println("aResult = " + aResult);

    }

}
