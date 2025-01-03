// Practice3
// 배열 arr 의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

// 입출력 예시)
// arr: 1, 3, 5, 7, 9
// 결과: 9, 7, 5, 3, 1

import java.util.Arrays;

public class Practice3 {

    public static void mySolution() {
        int[] arr = {1, 3, 5, 7, 9};
        int switch1 = 0;

        switch1 = arr[0];
        arr[0] = arr[4];
        arr[4] = switch1;
        switch1 = arr[1];
        arr[1] = arr[3];
        arr[3] = switch1;

//        for (int item: arr) {
//            System.out.println(arr[item]);
//        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void solution() {
        int[] arr = {1, 3, 5, 7, 9};

        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i]; // 잠시 임시보관 변수
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        mySolution();
        solution();



    }
}
