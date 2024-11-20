// Java 프로그래밍 - 변수와 자료형_3

public class Main {
    public static void main(String[] args) {

//      1. 자료형 - 문자열
        System.out.println("== 문자열 ==");
        String s1 = "Hello World!";
        System.out.println("s1 = " + s1); // s1 = Hello World!
        String s2 = "01234";
        System.out.println("s2 = " + s2); // s2 = 01234

//      1-1. equals
        String s3 = "Hi";
        String s4 = "Hi";
        // s3과 s4 두 변수를 비교해주는 두가지 방법. equals와 비교연산자
        System.out.println(s3.equals(s4));  // true
        System.out.println(s3 == s4);       // true

        String s5 = new String("Hi");
        System.out.println(s3.equals(s5));  // ture
        System.out.println(s3 == s5);       // false
        // equals는 변수가 가지고 있는 값을 비교함.
        // == 비교연산자는 객체를 비교함.
        // 문자열은 기존의 메모리를 잡아줌. new String은 새롭게 데이터를 만들어 줌.

//      1-2. indexOf
        // 문자열에서 특정 문자를 찾아주는 메소드. 인덱스열의 순번을 알려준다.
        String s6 = "Hello! World!";
        System.out.println(s6.indexOf("!")); // 5 .
        // 두번째 느낌표의 위치를 찾고싶다면?
        System.out.println(s6.indexOf("!", s6.indexOf("!") + 1)); // 12

//      1-3. replace
        String s7 = s6.replace("Hello", "Bye");
        System.out.println("s7 = " + s7); // s7 = Bye! World!


//      1-4. substring - 부분 문자열 출력
        System.out.println(s7.substring(0, 3)); // Bye
        // 직접 숫자를 쓰지 않고, indoxOf를 활용하는 법
        System.out.println(s7.substring(0, s7.indexOf("!") + 1)); // Bye! , +1이 없다면 Bye


//      1-5. toUpperCase
        System.out.println(s7.toUpperCase()); // BYE! WORLD!


//      2. 자료형 - StringBuffer
        System.out.println("== StringBuffer ==");
        StringBuffer sb1 = new StringBuffer();
        sb1.append("01234");
        System.out.println("sb1 = " + sb1); // sb1 = 01234
        sb1.append("56789");
        System.out.println("sb1 = " + sb1); // sb1 = 0123456789

//      StringBuffer가 아니라 일반 문자열에도 append 작업 가능.
//      문자열의 데이터가 많이 변경되거나 삭제될 경우가 빈번하면 StringBuffer 사용 권장.
//      StringBuffer는 데이터가 변경되어도 데이터가 새로 만들어지지 않음. 기존의 객체에서 변경됨.
//      String은 데이터의 변화가 생길때마다 새롭게 객체를 생성해서 거기에 데이터를 만들어준 다음 사용.
//      -> 객체가 여러번 만들어짐 -> 메모리 생성이 여러번 발생 -> 시스템적 속도 딜레이 발생.
        String a = "01234";
        String b = "56789";

//      String a가 변화가 발생하기 이전의 데이터
        String bak = a;
        System.out.println(a == bak); // true

        a += b;
        System.out.println(a); // 0123456789
//      String a가 변화가 발생한 후의 데이터. 새롭게 객체를 생성해서 다시 만들어 줬단 뜻.
        System.out.println(a == bak); // false

//      데이터 수정이 빈번하게 발생할 경우엔, StringBuffer를 사용하는 것이 좋다.

//      3. 자료형 - 배열
        System.out.println("== 배열 ==");
        int[] myArray1 = {1, 2, 3, 4, 5};
        System.out.println(myArray1[0]);
        System.out.println(myArray1[1]);
        System.out.println(myArray1[2]);
        System.out.println(myArray1[3]);
        System.out.println(myArray1[4]);

        char[] myArray2 = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(myArray2[2]); // c

//      배열을 만들 때 위 처럼 바로 초기화 하는 법, 아래처럼 특정 갯수를 명시해주는 법이 있다.
        String[] myArray3 = new String[3]; // String 배열 3개 생성
        // 각각의 데이터를 세팅
        myArray3[0] = "Hello";
        myArray3[1] = " ";
        myArray3[2] = "World!";
        System.out.println(myArray3[0] + myArray3[1] + myArray3[2]); // Hello World!



    }
}
