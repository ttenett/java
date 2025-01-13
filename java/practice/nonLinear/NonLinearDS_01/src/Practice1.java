// Practice1
// 배열을 이용한 이진 트리 구성, 순회
// order에 따라서 출력 위치만 변경해주면 됨.

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone(); // 생성자에서는 받아온 데이터를 클론
    }

    public void preOrder(int idx) {
        // 처음 들어온 인덱스에 해당하는 데이터를 먼저 출력
        System.out.print(this.arr[idx] + " ");

        // 현재 출력한 대상의 left, rigth 차일드를 구함
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if (left < this.arr.length) { // left의 인덱스가 배열 범위안에 들어있으면 해당 자식이 있는것
            // 재귀함수 형식으로 출력
            this.preOrder(left);
        }

        if (right < this.arr.length) {
            this.preOrder(right);
        }
    }

    public void inOrder(int idx) { // 왼쪽 출력, 현재 출력, 오른쪽 출력
        // 인덱스 먼저 구해줌
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // 왼쪽노드 따라 쭈욱 내려간다음
        if (left < this.arr.length) {
            this.inOrder(left);
        }
        // 출력을 시작
        System.out.print(this.arr[idx] + " ");

        if (right < this.arr.length) {
            this.inOrder(right);
        }
    }

    public void postOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < this.arr.length) {
            this.postOrder(left);
        }

        if (right < this.arr.length) {
            this.postOrder(right);
        }

        // 마지막에 출력을 시작
        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(int idx) {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}

public class Practice1 {
    public static void main(String[] args) {
        // Test code - 배열이 들어오면 순서대로 이진트리가 구성이 되었다라고 가정.
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
    }
}
