// Java 프로그래밍 - 내부 클래스


import com.sun.tools.javac.Main;

// 내부 클래스 구조
class Outer {
    public void print() {
        System.out.println("Outer.print");
    }

    class Inner {
        public void innerPrint() {
            Outer.this.print();
        }
    }

    static class InnerStaticClass {
        void innerPrint() {
//            Outer.this.print(); 정적특성상 메모리에 바로 올라감. Outer는 static이 아니라 메모리에 안올라감.
//            바로 사용할수 있는 형태의 메소드가 아님. 정적 내부클래스는 외부 접근이 안됨.
        }
    }
}

abstract class Person {
    public abstract void printInfo();
}

class Student extends Person {
    public void printInfo() {
        System.out.println("Student.printInfo");
    }
}

public class Main {

    public static void main(String[] args) {

//      외부 클래스 - 객체 생성
        Outer o1 = new Outer();

//      내부 클래스 - 인스턴스 사용법
//      타입 맞춰주고 = 객체 생성시 외부부터 만들고 내부객체 만들어서 접근 함.
        Outer.Inner i1 = new Outer().new Inner();

//      내부 클래스 - 정적 = Static이기 때문에 Outer에 객체 생성하지 않아도 됨.
        Outer.InnerStaticClass is1 = new Outer.InnerStaticClass();

//      익명 클래스 - new Person 클래스를 받아서 익명클래스를 안쪽에 만들어 사용. 한번만 쓸 수 있는 클래스.
        Person p1 = new Person() {
            @Override
            public void printInfo() {
                System.out.println("Main.printInfo");
            }
        };


    }

}
