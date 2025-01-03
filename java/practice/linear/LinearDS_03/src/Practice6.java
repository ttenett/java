// Practice6
// 배열 arr 에서 중복 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5
// 결과: 1, 5, 3, 2, 4
// hashset 사용하지않고 배열만 이용해서 풀기

public class Practice6 {

    public static void mysolution() {
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        for (int i = 0; i < arr.length; i++) {

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] arrResult = new int[arr.length]; // 중복을 제거해서 새로운 데이터를 넣을 배열
        int cnt = 0;

        // arr data를 쭉 반복
        for (int i = 0; i < arr.length; i++) {
            boolean dupFlag = false; // 값이 중복된 변수인지 아닌지 체크할 변수
            // arrResult를 반복(중복되지 않은 데이터 개수만큼 쌓임)
            for (int j = 0; j < cnt; j++) {
                if (arr[i] == arrResult[j]) {
                    dupFlag = true;
                }
            }
            //
            if (dupFlag == false) { // dupFlag == false, 아직 Result에 잡힌 데이터가 아님.
                // result에 해당 데이터를 넣어주고 cnt 증가
                arrResult[cnt++] = arr[i];
            }
        }
        // 출력하는 부분
        for (int i = 0; i < cnt; i++) {
            System.out.print(arrResult[i] + " ");
        }
        System.out.println();

    }
}
