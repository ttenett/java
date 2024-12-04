// Java 프로그래밍 - 추상 클래스

// 추상 클래스 Person
abstract class Person {
    abstract void printInfo();
}


// 추상 클래스 상속
class Student extends Person {
    public void printInfo() {
        System.out.println("Student.printInfo");
    }
}

public class Main {

    public static void main(String[] args) {
        
//        추상 클래스의 사용
//        Person p1 = new Person(); // 아무런 기능 구현된게 없어 추상클래스 객체로 만들기는 불가능
        Student s1 = new Student();
        s1.printInfo();

        // 추상클래스는 사용하는 다른 방법 - 익명클래스
        // new P까지 쓰면 오버라이드 부분 자동완성 기능.
        Person p2 = new Person() { 
            @Override
            void printInfo() {
                System.out.println("Main.printInfo");
            }
        };
        p2.printInfo();
    }

}
