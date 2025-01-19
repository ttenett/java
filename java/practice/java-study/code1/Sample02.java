package code1;

public class Sample02 {

    // 클래스 이름은 대문자로 시작. Class타입 - 참조형태
    // 상수든 변수든 의미있는 이름을 지어야 함.
    String myName;
    // String int 불가 - 예약어임
    // $는 가독성이 안좋음. 서버class 자동으로 만들어짐. 언더바로구분
    int 내_나이$값; 
    // 숫자로 시작할 수 없음.
    int 내1학기점수;
    int int_my_age;

    // 속성, 메서드 => camel 표기법
    int myAge;

    double 키;
    double 몸무게; // -> 값을 소수점으로 입력 가능.

    boolean 사용여부;

    char 코드 = 'a';


    public void test() {

        double 키1 = 180.14;
        float 키2 = (float) 178.15;

        // float이 double보다 훨씬 작으니 넘치지 않는 범위에서는 대입가능.
        키1 = 키2;

        String 나이;

    }

    public void test2() {

        int a = 10;
        int b = 20;

        // 단항연산자(피연산자 1개)
        // 후위, 전위
        a++;
        ++a;
        a--;
        --a;
        // 산술연산자 +, -, *, /, &
        // 비교연산자 >, >=, <, <=, ==, instanceof
        // 논리연산자 &, ^, |, &&, ||
        // 이항연산자(피연산자 2개)
        // 삼항연산자(피연산자 3개) a==b ? c | d
        // 대입연산자 = :오른쪽의 처리결과, 값을 왼쪽에 대입
        
    }

    public static void main(String[] args) {
        System.out.println();
        
    }


}
