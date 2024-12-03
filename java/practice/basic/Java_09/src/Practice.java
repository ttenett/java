// Practice
// 아래의 클래스와 상속 관계에서 다형성을 이용하여
// Car 객체를 통해 아래와 같이 출력될 수 있도록 Test code 부분을 구현해보세요.
// 빵빵!
// 위이잉!
// 삐뽀삐뽀!

class Car {
    Car(){}
    public void horn() {
        System.out.println("빵빵!");
    }
}

class FireTruck extends Car {
    public void horn() {
        System.out.println("위이잉!");
    }
}

class Ambulance extends Car {
    public void horn() {
        System.out.println("삐뽀삐뽀!");
    }
}

public class Practice {
    public static void main(String[] args) {
        // Test code
        System.out.println("== 내답 =="); // car 객체를 통해 계속 출력하기. 문제 꼼꼼히 읽기
        Car car1 = new Car();
        car1.horn();

        Car truck = new FireTruck();
        Car amb = new Ambulance();
        truck.horn();
        amb.horn();

        System.out.println("== 강사님 답 ==");
        Car car = new Car();
        car.horn();

        car = new FireTruck();
        car.horn();

        car = new Ambulance();
        car.horn();


        // 좀더 멋지게 작성가능
        Car car2[] = {new Car(), new FireTruck(), new Ambulance()};

        for (Car item: car2) {
            item.horn();
        }



    }
}
