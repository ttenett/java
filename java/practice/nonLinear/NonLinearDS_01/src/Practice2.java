// Practice2
// 연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node { // Testcode에서 char형 자료를 이용하고 있으므로 노드변수, 생성자 만들어주기
    char data;
    Node left;
    Node right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2 {
    Node head;

    BinaryTree2() {}
    BinaryTree2(char[] arr) { // 아래의 char형 배열을 받아서 연결작업 하는 부분
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) { // for문을 돌면서 각각의 위치에 newNode로 할당해서 데이터를 넣어줌
            nodes[i] = new Node(arr[i], null, null);
        }
        // 다시반복문을 돌면서 현재노드에 대해서 자식노드 연결 시켜줌
        for (int i = 0; i < arr.length; i++) {
            // 좌, 우 인덱스
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) { // 인덱스에 대한 범위체크. 자식노드가 있으면 현재노드의 왼쪽에 연결
                nodes[i].left = nodes[left];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }
        // 루트노드에 대한 연결
        this.head = nodes[0];
    }

    public void preOrder(Node node) {
        if (node == null) { // 재귀함수의 탈출조건
            return;
        }

        // 현재것을 먼저 출력하고 왼쪽 오른쪽 탐색
        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node cur = queue.poll(); // 큐에서 하나 꺼냄

            System.out.print(cur.data + " "); // 출력
            // 링크검사
            if (cur.left != null) {
                // 자식노드가 있으면 큐에 다시 넣어주기
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

}


public class Practice2 {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
