// 선형 자료구조 - 큐


import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        // Queue는 인터페이스로 구성되어 있음. 다형성을 이용해서 할당하여 사용하기로

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.poll()); // 1이 나옴
        System.out.println(queue);

        System.out.println(queue.poll()); // 2 나옴
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.contains(3));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll()); // null



    }
}
