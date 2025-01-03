// Practice7
// 2차원 배열 arr 을 시계방향 90도 회전시킨 결과를 출력하세요.

// 입출력 예시:
// arr:
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
// 결과:
// 11 6 1
// 12 7 2
// 13 8 3
// 14 9 4
// 15 10 5
// 2차원 배열 arr을 시계방향으로 90도 출력한 결과

//20 10 00
//21 11 01
//22
//23
//24
public class Practice7 {

    public static void solution() { // 세줄 ㅅㅂ 어케해ㅠ
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

        for (int i = 2; i < arr.length; i--) { // 2, 1, 0
            int[] inArr = arr[i];
            for (int j = 0; j < inArr.length; j++) { // 0만 뽑기
                System.out.println(inArr[j]);
            }
        }

    }

    // 출력하는 메소드
    static void printArr(int[][] arr) {
        for (int[] item10: arr) {
            for (int item: item10) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //solution();

        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int[][] arr90 = new int[arr[0].length][arr.length]; // 왼쪽은 열의개수, 오른쪽은 행의개수가 들어옴

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int r = arr.length - 1 - i; // 길이에서 1을빼고 i를 빼줌. 열 위치에 데이터를 넣어줌.
                arr90[j][r] = arr[i][j];
            }
        }

        printArr(arr);
        System.out.println("== After ==");
        printArr(arr90);




    }
}
