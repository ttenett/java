// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 (simple ver.) 기본 구조 구현

import org.w3c.dom.ls.LSOutput;

// 노드 - 값과 링크를 관리하는 부분으로 이루어짐
class Node {
    int data;
    // 자기 자신의 클래스를 가르킬 노드자료형
    // 여러 노드들이 있을때 이 다음 노드를 가르키는 역할
    Node next;

    Node() {}
    // 노드 클래스를 생성할때 데이터, 링크를 넣어서 바로 생성할 수 있게 준비.
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;
    // 생성자 만들기
    LinkedList() {}
    LinkedList(Node node) {
        this.head = node;
    }

    //  연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }


    //  연결 리스트의 맨 뒤에 데이터 추가
    public void addData (int data) { // 연결리스트의 addData 호출 ,int data 값 넣어줌
        if (this.head == null) { // 만약 이 연결리스트의 head가 null이라면
            this.head = new Node(data, null); // 가장 맨 처음의 head에 node 생성, head에 할당
        } else { // 만약 노드들이 있으면
            // 현재를 뜻하는 current, 값이 있을때까지 쭉 순회.
            Node cur = this.head; // head 로부터 node를 하나씩 순회, 끝까지 도달
            while (cur.next != null) {
                // cur이 노드의 data부분을 가르킴(null 앞에서 멈춤)
                cur = cur.next; // 이때 cur 변수에 null이 있는 next를 넣음.
            }
            // 가장 끝에 도달했을 때 node 추가
            cur.next = new Node(data, null);
        }
    }


    //  연결 리스트의 맨 뒤의 데이터 삭제
    // 자바의 경우 메모리를 자동으로 해제해줌. 링크 부분만 관리해주면 됨.
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        // cur = 마지막 노드를 찾아서 삭제하는 역할
        // prev= cur을 따라다니면서 그 앞의 노드의 링크를 삭제하는 역할
        Node cur = this.head;
        Node prev = cur;

        while (cur.next != null) {
            prev = cur; // cur보다 하나 이전의 노드를 prev가 따라다님
            cur = cur.next;
        }

        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }


    //  연결 리스트에서 데이터 찾기
    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) { // 반복문 순회하며 찾고자하는 data와 같은지 비교
                System.out.println("Data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
    }



    //  연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}


public class Main {

    public static void main(String[] args) {

//      Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();      // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();      // 1 2 3 4 5

        myList.findData(3);     // Data exist!
        myList.findData(100);   // Data not found!

        myList.removeData(); // 끝에서부터 삭제
        myList.removeData();
        myList.removeData();
        myList.showData();      // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData();    // List is empty

    }

}
