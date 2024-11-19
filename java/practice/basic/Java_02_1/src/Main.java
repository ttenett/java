// Java 프로그래밍 - 변수와 자료형_1

public class Main {
    public static void main(String[] args) {

//      1. 변수 사용하기
        System.out.println("== 변수 사용하기 ==");
        int age = 10;
        System.out.println(age);
        String country = "Korea";
        System.out.println(country);

//      2. 변수 이름 규칙
        System.out.println("== 변수 이름 규칙 ==");
//      2-1. 문자, 숫자, _(underscore), $ 사용 가능
        int apple = 2000;
        int apple3 = 2000;
        int apple = 2000;
        int $apple = 2000;
        System.out.println($apple);               // sout 누르면 System.out.println 자동완성
        System.out.println("$apple = " + $apple); // soutv 엔터 : 자동으로 바로 위의 포맷으로 맞춰 출력해줌.

//      2-2. 숫자로 시작 X
        // int 3apple = 2000;

//      2-3. 대소문자 구분
        int apple5 = 1000;
        int Apple5 = 1000;

//      2-4. 공백 사용 X
        int one_apple = 1000;
        int oneApple = 1000;

//      2-5. 예약어 사용 X
//      예약어 예시: true, false, if, switch, for, continue, break, ...
        // int true = 1;

//      참고) 한글 사용 가능
        int 사과 = 1000;
        System.out.println("사과 = " + 사과);


//      3. 표기법
//      3-1. 카멜 표기법 (camelCase) 맨앞 소문자, 나머지 앞글자 대문자
//      변수, 함수
        int myAge = 10;
        int oneApplePrice = 1000;

        
//      3-2. 파스칼 표기법 (PascalCase) 모두 첫글자 대문자
//      클래스
        int MyAge = 10;
        int OneApplePrice = 1000;

        
//      참고) 스네이크 표기법 (snake_case) 모두 소문자, 단어간 연결은 언더바_
//      사용 X , 자바에서는 사용하지 않고 파이썬에서 사용함.
        int my_age = 10;
        int one_apple_price = 1000;


    }
}

