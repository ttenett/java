package code1;

public class Sample01 {

    // 일반적인 변수, final을 붙이면 상수가 됨.
    final int MONTH = 12;

    // 위처럼 선언과 초기화 동시에 해도 되고, 
    //선언만 해도 됨. -> 반드시 초기화 해야함.
    final int DAY;

    // 문자열도 초기화! 데이터 상수화 가능.
    final String ERROR_MESSAGE = "에러가 발생하였였습니다";

    // 선언만 한 변수는 생성자를 통해서 초기화를 해줌.
    public Sample01(int day) {
        this.DAY = day;
    }

    public static void main(String[] args) {
        
        System.out.println("Test!");
    }
    
}
