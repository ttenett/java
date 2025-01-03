// Practice2
// 배열 arr 에서 target 에 해당하는 값의 인덱스를 출력
// 해당 값이 여러 개인 경우 가장 큰 인덱스 출력

// 입출력 예시)
// 배열 arr: 1, 1, 100, 1, 1, 1, 100
// target: 100
// 결과: 6

import java.util.Arrays;
import java.util.Scanner;

public class Practice2 {

    public static void mySolution() {
        int[] arr = {1, 1, 100, 1, 1, 1, 100};

//        Scanner sc = new Scanner(System.in);
//        System.out.print("target: ");
//        int target = sc.nextInt();
        int target = 100;
        for (int item: arr) {
            if (target == arr[item]) {
                System.out.println(arr[item]);
            }
        }


    }

    public static void solution() {
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        int target = 100;
        int idxMax = -1; // 가장 작은것보다 더 작은것으로 초기화

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) { //배열에 타겟과 같은 값이 있으면
                if (i > idxMax) { // 기존 idxMax보다 크면 갱신
                    idxMax = i;
                }
            }
        }
        // 찾고자 하는 값이 있으면 출력 됨.
        if (idxMax >= 0) {
            System.out.println(idxMax);
        }
    }

    public static void main(String[] args) {
        solution();

    }
}
