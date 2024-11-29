// Java 프로그래밍 - 클래스와 객체_2

import car.Car2;

class Car {
    String name;
    String type;

    Car(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void printCarInfo() {
        System.out.println("=== Car Info ===");
        System.out.println("name: " + name);
        System.out.println("type: " + type);
    }

    // 오버로딩 구현
    public void printCarInfo(String date) { // 매개변수 타입이나 개수 바꾸면 됨
        this.printCarInfo(); // 원래 정보 출력
        System.out.println("date: " + date);
    }

    public void printCarInfo(int number) {
        this.printCarInfo();
        System.out.println("number: " + number);
    }

    public void printCarInfo(String date, int number) {
        this.printCarInfo();
        System.out.println("date: " + date);
        System.out.println("number: " + number);
    }

}


class Car3 {
    // 스태틱 변수
    static String name = "None"; // static 객체가 만들어지기 전부터 name 이라는 변수는 이미 만들어짐.
    String type;

    Car3(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void printCarInfo() {
        System.out.println("=== Car Info ===");
        System.out.println("name: " + name);
        System.out.println("type: " + type);
    }

    // 스태틱 메소드
    // 스태틱 메소드로 되어있으면 여기서 사용할 수 있는 변수도 스태틱이어야 함.
    public static void getName() { // 이름을 반환해주는 getName 메소드
        System.out.println("Car name: " + name);
    }

}


public class Main {

    public static void main(String[] args) {
        Car myCar1 = new Car("a", "sedan");
        myCar1.printCarInfo();

//      1. 오버로딩 사용
        System.out.println("=== 오버로딩 사용 ===");
        myCar1.printCarInfo("2024");
        myCar1.printCarInfo(1234);
        myCar1.printCarInfo("2024", 1234);



//      2. 접근 제어자 - 접근 권한에 맞게끔 사용해주면 된다.
        System.out.println("=== 접근 제어자 ===");
        // car 패키지 생성, Car2 클래스 생성
        Car2 myCar2 = new Car2("a", "b", "c", "d");
        System.out.println(myCar2.name1); // 접근해서 출력
//        System.out.println(myCar2.name2);
//        System.out.println(myCar2.name3);
//        System.out.println(myCar2.name4);
        // 패키지 클래스에서 public 설정 > 모두 접근이 가능해서 출력이 정상적으로 됨.
        // public외 private, protected, default 설정 하니 빨간색으로 접근 불가.
        // -> 외부에서 접근을 위해서는 public으로 설정해줘야 함. protected는 상속받은 클래스에서는 사용가능.

//      3. Static
        System.out.println("=== Static ===");
        //Car3.getName(); 오류남. 스태틱 메서드에서 public void getName()에서 static 추가.
        Car3.getName(); // 객체를 81번 줄처럼 만들지 않았는데, 클래스명을 통해서 해당 메소드 호출 할 수 있음.
        //객체 직접 만들어보기
        Car3 myCar3_1 = new Car3("a", "sedan");
        Car3 myCar3_2 = new Car3("b", "suv");
        Car3 myCar3_3 = new Car3("c", "rv");
        myCar3_1.printCarInfo();
        myCar3_2.printCarInfo();
        myCar3_3.printCarInfo(); // name은 모두 c가 나옴.
        // static 특성으로 다른 객체에서 데이터를 바꿔주면, 마지막에 바뀐 데이터 공유되어 해당정보만 출력됨.

        
    }

}