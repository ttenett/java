// Practice1
// 배열 arr 의 모든 데이터에 대해서,
// 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하세요.

// 입출력 예시)
// 배열 arr: 1, 2, 3, 4, 5, 6, 7, 8, 9
// 결과:
// 짝수 평균: 5.0
// 홀수 평균: 5.0

public class Practice1 {

    public static void mySolution() {
        //내 풀이
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int evenNumber = 0;
        int oddNumber = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                // 새로운 배열에 담아야하나?
                int even = arr[i];
                evenNumber += even;
                a += 1;
            } else {
                int odd = arr[i];
                oddNumber += odd;
                b += 1;
            }
        }
        double evenavg = (double) evenNumber / a;
        double oddavg = (double) oddNumber / b;
        System.out.println("짝수 평균: " + evenavg);
        System.out.println("홀수 평균: "+ oddavg);
        // for each 문으로 순회하는걸 만들 수 있지 않으려나
    }

    public static void solution() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        float sumEven = 0;
        float sumOdd = 0;
        int evenCnt = 0;
        int oddCnt = 0;

        for (int item: arr) {
            if (item % 2 == 0) {
                // 짝수들의 합을 계속 더해줌
                sumEven += item;
                // 짝수가 몇개인지 카운트
                evenCnt++;
            } else {
                sumOdd += item;
                oddCnt++;
            }
        }
        System.out.println("짝수 평균: " + sumEven / evenCnt);
        System.out.println("홀수 평균: " + sumOdd / oddCnt);
    }

    public static void main(String[] args) {
        System.out.println("==내 풀이==");
        mySolution();

        System.out.println("==강사님 풀이==");
        solution();



    }

}
