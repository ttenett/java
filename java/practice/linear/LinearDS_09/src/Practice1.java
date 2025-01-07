// Practice1
// 카드 섞기
// 1부터 N 까지의 번호로 구성된 N장의 카드가 있다.
// 1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태로 카드가 순서대로 쌓여있다.
// 아래의 동작을 카드 한 장만 남을 때까지 반복했을 때, 가장 마지막 남는 카드 번호를 출력하시오.
// 1. 가장 위의 카드는 버린다.
// 2. 그 다음 위의 카드는 쌓여 있는 카드의 가장 아래에 다시 넣는다.

// 예시 입력)
// N = 4
// 결과: 4

// N = 7
// 결과: 6


import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Practice1 {
    public static int findLastCard(int N) {
        Queue queue = new LinkedList();
// 내가 작성한 코드
//        for (int i = 1; i < N + 1; i++) {
//            // 1 ~ N장의 카드 생성
//            queue.add(i);
//        }
//        // 큐에 하나 남았을 때 프린트하고, 중지
//        // NullPointerException 예외발생
//        for (int i = 0; i < N; i++) {
//            if (!queue.isEmpty()) {
//                queue.poll();
//                // 맨위 카드 버리고, 그다음꺼 밑으로 넣기 어떻게 하지?
//                int nextCard = (int) queue.poll();
//                queue.add(nextCard);
//            } else if (queue.size() == 1) {
//                System.out.println(queue);
//                break;
//            }
//        }
//        return (int) queue.peek();

        // N장의 카드를 쌓는 과정, for문으로 add 시켜줘도 됨.
        IntStream.range(1, N + 1).forEach(x -> queue.add(x));
        System.out.println(queue);
        // queue 사이즈가 1보다 클 동안
        while (queue.size() > 1) {
            // 첫 1장 버림
            queue.remove();
            // 두번째 장 꺼내어 형변환 해주고 다시 삽입. 큐는 처음 들어온게 먼저 나옴. 가장 뒤에 들어감.
            int data = (int)queue.remove();
            queue.add(data);
            // 차례대로의 결과를 보기 위해서 queue상태 출력
            System.out.println(queue);
        }
        // 마지막 남은 한장을 리턴.
        return (int)queue.remove();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(findLastCard(4));    // 4
        System.out.println(findLastCard(7));    // 6
        System.out.println(findLastCard(9));    // 2
    }
}
