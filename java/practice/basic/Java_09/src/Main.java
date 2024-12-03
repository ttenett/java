// Java 프로그래밍 - 다형성

class Person {
    public void print() {
        System.out.println("Person.print");
    }
}

class Student extends Person {
    public void print() {
        System.out.println("Student.print");
    }

    public void print2() {
        System.out.println("Student.print2");
    }
}

class CollegeStudent extends Person {
    public void print() {
        System.out.println("CollegeStudent.print");
    }
}


public class Main {

    public static void main(String[] args) {

//      1. 다형성
        System.out.println("== 다형성 ==");
        Person p1 = new Person();       // 자기 클래스 객체를 자기 클래스 타입이 가르킴. 문제없음.
        Student s1 = new Student();

        Person p2 = new Student(); // 자식이 객체인데, 부모클래스의 타입으로 만들어줌.
//        Student s2 = new Person(); 반대로는 불가.

        p1.print();
        s1.print();
        s1.print2();
        p2.print();     //Student.print p2의 대상은 student의 객체. p2는 타입이 Person이지만 출력결과는 student쪽에서.
//      p2.print2();    불가함. Person이 알고있는 메소드, 오버라이딩 된 부분까지만 적용. print2는 없는 것으로 알고있음.

        Person p3 = new CollegeStudent();
//        CollegeStudent c1 = new Student();  같은 부모를 상속했다 해도, 자식끼리는 다형성 성립 불가
        p3.print();


//      2. 타입 변환
        System.out.println("== 타입 변환 ==");
        Person pp1 = null;
        Student ss1 = null;

        Person pp2 = new Person();
        Student ss2 = new Student();
        Person pp3 = new Student(); // -> 업캐스팅. 자식클래스의 객체가 부모클래스의 타입으로 형변환 되는 것.

        pp1 = pp2;  // 같은 타입을 가르켜서 문제 없음.
        pp1 = ss2;

        ss1 = ss2;
//      ss1 = pp2;  자식이 부모를 가르키는거 안됨.
        ss1 = (Student)pp3;  // 다운캐스팅. 자기 객체가 부모클래스로 업캐스팅 돼서 타입만 person이었으므로 , 다시 자신 클래스쪽으로 타입변환

        CollegeStudent cc1;
        CollegeStudent cc2 = new CollegeStudent();
//        ss1 = (Student) cc2;  같은 부모클래스여도 자식끼리의 형변환 되지 않음.
//        cc1 = (CollegeStudent) ss2;


//      3. instanceof - 해당 객체의 인스턴스가 맞는지 체크해주는 기능
        System.out.println("== instanceof ==");
        Person pe1 = new Person();
        Student st1 = new Student();
        Person pe2 = new Student();
        Person pe3 = new CollegeStudent();

        System.out.println(pe1 instanceof Person);  // true
        System.out.println(pe1 instanceof Student); // f 맞음! Person의 객체임.

        System.out.println(st1 instanceof Person);  // f 틀, Person 부모클래스를 상속받아 만든 객체
        System.out.println(st1 instanceof Student); // t

        System.out.println(pe2 instanceof Person);  // t
        System.out.println(pe2 instanceof Student); // f 틀

        System.out.println(pe3 instanceof Person);  // t
        System.out.println(pe3 instanceof CollegeStudent);  // f 틀

//      instanceof를 이용해서 다형성을 쓸 수 있는지 없는지 여부를 알 수 있다.\
//      미리 검사를 해보고 형변환을 해주는 코드를 작성 가능.

        if (pe1 instanceof Student) {
            Student stu1 = (Student) pe1;
        }

        if (st1 instanceof Person) {
            Person per1 = (Person)st1;
        }




    }
}
