// Java 프로그래밍 - 상속

class Person {
    String name;
    int age;
    public int a1;
    private int a2;

    Person() {}
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Person.printInfo");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }
}

// Student 클래스 - Person 상속, 접근제어자 확인
class Student extends Person {
// 부모클래스에서 접근제어자에 따른 상속 범위 확인
    Student() {
        a1 =1;
//        a2 = 1;
    }
}

// Student 클래스 - Person 상속, super 사용, 오버라이딩
class Student2 extends Person {
    String name;
    int stdId;

    Student2(String name, int age, int stdId) { // 생성자에서 데이터 초기화 해줌
        this.name = name;   // 자기 객체이므로 St2의 name을 뜻함. 부모클래스에도 name이 있지만 똑같은 변수가 있으므로.
//        부모 쪽 name 변수를 사용하고 싶다면?
//        super.name = name;
//        super(name, age); // 부모클래스의 생성자 호출.
        this.age = age;     // St2에 age 변수가 없으므로 부모의 age를 뜻함.
        this.stdId = stdId; // 부모에 없는 변수. 자기객체의 변수임.
    }
//  오버라이딩
    public void printInfo() {
        System.out.println("Student2.PrintInfo");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("stdId: " + stdId);
    }


}


public class Main {

    public static void main(String[] args) {

//      Test code
//      1. 상속
        System.out.println("=============");
        Student s1 = new Student();
        s1.name = "a";
        s1.age = 25;
        s1.printInfo();


//      2. super, super(), 오버라이딩
        System.out.println("=============");
        Student2 s2 = new Student2("b",32, 1);
        s2.printInfo();
        // Student2.PrintInfo
        //name: null
        //age: 32
        //stdId: 1
//        -> super(name, age); 상태. st2에서 name 초기화 해줄때 부모쪽으로 넘겨서 40줄 super()초기화가 되어있고, 자기쪽의 name은 아무것도 할당되어있지 않음
//        기본적으로 name은 자기객체의 것을 먼저 가져다 씀. null 나옴.
//      this.name으로 바꾸면? name b가 잘 출력됨.

    }
}
