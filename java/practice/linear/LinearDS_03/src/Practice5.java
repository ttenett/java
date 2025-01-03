// Practice5
// 배열 arr 의 값을 오름차순으로 출력

// 입출력 예시)
// arr: 5, 3, 1, 4, 6, 1
// 결과: 1, 1, 3, 4, 5, 6

public class Practice5 {

    public static void mysolution() {


    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 1};
        // 배열을 for문을 돌며 가장 작은 값을 출력시킬 것임. 이미 출력한 애는 출력한 표시를 하기 위한 배열
        int[] visited = new int[arr.length];
        int visitCnt = 0;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        while (visitCnt < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                // 배열의 값이 minVal 보다 작고, 이미 출력한 데이터가 아니면
                if (arr[i] < minVal && visited[i] == 0) {
                    // minVal에 해당값을 넣어주고 최소인덱스를 minIdx에 잡아줌.
                    minVal = arr[i];
                    minIdx = i;
                }
            }
            // 가장 최소에 해당하는 인덱스가 -1이 아니면 출력,
            if (minIdx != -1) {
                System.out.print(minVal + " ");
                // 해당 인덱스 위치를 이미 방문햇다는 의미로 1로 만들어줌
                visited[minIdx] = 1;
                visitCnt++;
            }
            // 그다음 반복문을 돌리기 전에 minimumValue를 다시 integerMaxValue로 잡아줌
            minVal = Integer.MAX_VALUE;
            // 최솟값은 -1로 초기화
            minIdx = -1;
        }
        System.out.println();
    }
}
