// Practice3
// 트리 구조 복습 / 구현


import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    char data;
    Node2 left;
    Node2 right;
    // 구현의 편리성을 위해 부모로 갈 수 있는 길을 뚫어놓기
    Node2 parent;

    public Node2(char data, Node2 left, Node2 right, Node2 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
class BinaryTree3 {
    Node2 head;

    BinaryTree3(char[] arr) {
        // 만들면서 parent 쪽도 연결시키는 부분 추가
        Node2[] nodes = new Node2[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node2(arr[i], null, null, null); // 노드들 초기화
        }

        for (int i = 0; i < arr.length; i++) {
            // 자식노드 인덱스 찾기
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i]; // 부모쪽도 연결
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node2 searchNode(char data) {
        Queue<Node2> queue = new LinkedList<>();
        queue.add(this.head); //탐색 시점은 head로부터 출발
        while(!queue.isEmpty()) {
            Node2 cur = queue.poll();
            if (cur.data == data) { // queue로부터 데이터를 꺼내서 그 데이터가 찾고자 하는것과 일치
                return cur; // 현재 위치의 노드를 반환
            } // 아니면 계속 순회를 이어나감

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        // 다 순회했는데도 데이터가 없으면 null 반환
        return null;
    }

    public Integer checkSize(char data) {
        Node2 node = this.searchNode(data);

        Queue<Node2> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;
        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
                size++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                size++;
            }
        }
        return size + 1;
    }

}

public class Practice3 {

    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        // Root node
        System.out.println("Root: " + bt.head.data);

        // B's child node
        Node2 B = bt.searchNode('B');
        if (B.left != null) {
            System.out.println("B -> left child: " + B.left.data);
        }
        if (B.right != null) {
            System.out.println("B -> right child: " + B.right.data);
        }

        // F's parent node
        Node2 F = bt.searchNode('F');
        System.out.println("F -> parent: " + F.parent.data);


        // Leaf node - 말단, 자식노드가 없는 노드
        System.out.print("Leaf node: ");
        for (int i = 0; i < arr.length; i++) { // 배열에 들어있는 데이터를 이용하기위해 for문을 돌림
            Node2 cur = bt.searchNode((char)('A' + i)); // 각각의 노드들을 우선 찾음

            // 찾은 각각의 노드들에 대한 자식노드들을 찾기
            if (cur.left == null && cur.right == null) {
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();


        // E's Depth - 루트노드로부터 E라는 노드까지 간선을 몇번거치는지 횟수 구하기
        Node2 E = bt.searchNode('E');
        Node2 cur = E;
        int cnt = 0;
        while (cur.parent != null) {
            cur = cur.parent; // 올라갈때마다 개수세기
            cnt++;
        }
        System.out.println("E depth: " + cnt);


        // Level2 Node - 특정 레벨의 노드 출력
        System.out.print("Level2 node: ");
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode((char)('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if (cnt == 2) {
                System.out.print(target.data + " ");
            }
        }
        System.out.println();

        // Height
        int maxCnt = Integer.MIN_VALUE; // 비교변수를 위해 최솟값 넣음
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode((char)('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }
        System.out.println("Height: " + maxCnt);

        // B's Size
        int size = bt.checkSize('B');
        System.out.println("B size = " + size);



    }
}
