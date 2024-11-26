// Java 프로그래밍 - 반복문

public class Main {
    public static void main(String[] args) {

//      1. 반복문 - for
        System.out.println("== for ==");
//      1-1. 기본 사용 방법
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // for 문으로 별찍기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // for - continue 문
        System.out.println();
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue; // 반복문이 contiune를 만나면 그 아래코드는 실행하지 않고 그 다음으로 넘어감.
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // for - break 문
        System.out.println();
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                break; // 반복문이 break를 만나면 그 즉시 멈춤. 탈출함. 더이상 실행하지 않고 종료.
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


//      1-2. for each
        System.out.println("== for each ==");
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 0; i < 5; i++) {
            System.out.println(nums[i]);
        }

        // 조건문에 배열의 길이 대신, length사용
        System.out.println("== for each ==");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        // for each - 모든 원소를 순회할 때 편리하다~!!
        // 대상의 자료형 + 변수 : 반복하고자 하는 대상 , 변수 출력 = 모두 순회하면서 출력해줌.
        for (int num : nums) {
            System.out.println(num);
        }
        // 증가문이 특이할 경우,(2씩,3씩 증가처럼 변형) 기존 for문을 사용.


//      2. 반복문 - while
        System.out.println("== while ==");
//      2-1. while
        int i = 0; // i 를 바깥에서 선언
        while (i < 5) {
//          System.out.println(i); 이렇게 쓰면 무한루프에 걸림.
            System.out.println(i++);
        }

        // contiune
        System.out.println();
        i = 0;
        while (i < 5) {
            if (i == 2) { // i가 2일때 continue를 만나서 얘만 넘어가고 실행.
                i++;
                continue;
            }
            System.out.println(i++);
        }

        // break
        System.out.println();
        i = 0;
        while (i < 5) {
            if (i == 2) { // i가 2일때 break를 만나서 반복문 탈출.
                i++;
                break;
            }
            System.out.println(i++);
        }

// continue, break는 for과 while문 둘 다 적용됨.

//      2-2. do-while
        System.out.println("== do-while ==");
        boolean knock = false;
        do{
            System.out.println("knock");  // false이지만 do를 먼저 실행함.
        } while (knock);


        System.out.println("== Q1 ==");
//      Q1. 아래와 같은 출력 결과를 반복문과 조건문을 이용하여 출력해보세요.
//      *
//      ***
//      *****
//      *******
        // 내답. 이게 최선이야; 근데 중간중간 줄 ln을 읎애고 싶은디.
        System.out.println("== 내가 쓴 답 ==");
        for (int a = 0; a < 8; a++) {
            for (int j = 0; j < a; j++) {
                if (a % 2 == 0 ) {
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
        }

        // 강사님 답
        System.out.println("== 강사님 답 ==");
        for (int j = 0; j < 8; j++) {
            if (j % 2 == 0) {
                continue;
            }

            for (int k = 0; k < j; k++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println("== Q2 ==");
//      Q2. 반복문을 실행할 때마다 물 온도를 1도씩 올리고 100도가 되면 종료한다.
//          추가로, 10도, 20도, ... 10도 간격으로 물 온도를 출력하시오.
        int waterTemperature = 0;
        for (waterTemperature = 0; waterTemperature < 101; waterTemperature++) {
            if (waterTemperature % 10 == 0) {
                System.out.println(waterTemperature + "도");
            }
        }

        // 강사님 답
        System.out.println("== 강사님 답 ==");
        waterTemperature = 0;
        while (waterTemperature < 100) {
            waterTemperature++;

            if (waterTemperature % 10 == 0) {
                System.out.println(waterTemperature + "도 입니다.");
            }
        }
        // 내 답에는 0도가 출력되는 이유: for문은 0부터 시작하고, while문은 ++를 먼저 해 준 다음 if문을 실행해서이다.

    }
}
