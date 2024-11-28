//  Practice
//  다음 클래스 직접 만든 후 객체 생성
//  클래스명: Animal
//  특성: 이름, 무게, 분류
//  기능: 먹기, 잠자기, 걷기, 뛰기

class Animal {
    String name;
    double weight;
    String type; // classification

    Animal(String name, double weight, String type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public void printInfo() {
        System.out.println("나는 " + name + " 에요!"); // soutv형식
        System.out.println("몸무게는 비밀(" + weight + ")이지롱!");
        System.out.println("저의 조상은 " + type + " 래요.");
    }

    public void eat() {
        System.out.println("맛있당 마싯땅!"); // 냠냠
    }

    public void sleep() {
        System.out.println("쿨쿨 zzZ");
    }

    public void walk() {
        System.out.println("뚜벅뚜벅");
    }

    public void run() {
        System.out.println("뛰기 시러어어어ㅓ어ㅓㅓ");
    }
}

public class Practice {
    public static void main(String[] args) {
        // Test code
        Animal animal1 = new Animal("강아지", 5.0, "포유류");
        Animal animal2 = new Animal("구피", 0.01, "어류");

       animal1.printInfo();
        animal2.printInfo();
        animal1.run();
        animal1.eat();
        animal2.walk();
        animal2.sleep();
    }
}
