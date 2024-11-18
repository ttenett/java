// Java 프로그래밍 - 조건문

public class Main {
    public static void main(String[] args) {

//      1. 조건문 - if
//      처음 맞는 조건을 만나면, 그 이후 조건은 실행하지 않음.
        System.out.println("== if ==");
        int waterTemperature = 100;

        if (waterTemperature >= 100) {
            System.out.println("물이 끓습니다.");
        } else {
            System.out.println("물을 끓이는 중입니다.");
        }

        // 점수에 따라 grade 매기기
        int score = 60;
        char grade = 0;
        // 90점 이상 A, 80점 이상 B, 70점 이상 C, 그외 F
        if (score >= 90) {
           grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'F';
        }
        System.out.println("grade = " + grade);


//      2. 조건문 - switch
        System.out.println("== switch ==");
        String fruit = "apple2";

        switch (fruit) {
            case "apple":
                System.out.println(fruit + "은 5,000원 입니다.");
                break;
            case "blueberry":
                System.out.println(fruit + "은 10,000원 입니다.");
                break;
            default:
                System.out.println("해당 과일이 없습니다.");
                break;
        }



//      Q1. number의 값이 홀수인지 짝수인지 판단하는 코드를 작성하세요.
        int number = 5;
        if (number % 2 == 0) {
            System.out.println(number + "은(는) 짝수입니다!");
        } else {
            System.out.println(number + "은(는) 홀수입니다!");
        }


//      Q2. 아래 주석은 위의 실습에서 진행한 score에 따라 grade를 출력하는 코드이다.
//        이를 switch 조건문 기반으로 바꿔보세요.
//        int score = 90;
//        char grade = 0;
//        if (score >= 90) {
//            grade = 'A';
//        } else if (score >= 80) {
//            grade = 'B';
//        } else if (score >= 70) {
//            grade = 'C';
//        } else {
//            grade = 'F';
//        }
//        System.out.println("grade = " + grade);

        score = 85;
        grade = 0;
        // 내가 한 것
        switch (score) {
            case 90:
                System.out.println("A");
                break;
            case 80:
                System.out.println("B");
                break;
            case 70:
                System.out.println("C");
                break;
            default:
                System.out.println("F");
        }

        // 강사님이 한거
        switch (score) {
            case 90:
                grade = 'A';
                break;
            case 80:
                grade = 'B';
                break;
            case 70:
                grade = 'C';
                break;
            default:
                grade = 'F';
        }
        System.out.println("grade = " + grade);
//      -> 위의 방법대로 하면, switch문은 if문이 아니라 해당되지 않는 조건이면 default로 간다. 원하지 않는 값 나옴.

        // ★수정하면,
        switch (score / 10) {   // 100이 10, 99점은 9점. scale이 1에서 10으로 바뀜.
            case 10:    // break가 없으니 90점 범위까지 실행이 됨.
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            default:
                grade = 'F';
        }
        System.out.println("grade = " + grade);

    }
}
