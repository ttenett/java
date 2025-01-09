// Practice3
// 원형 연결 리스트 (Circular Linked List) 구현

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.head;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }


    // 연결 리스트에 데이터 추가
    // before_data 가 null 인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData (int data, Integer beforeData) {
        if (this.head == null) {
            NodeBi newNodeBi = new NodeBi(data, null, null);
            // 처음에는 노드가 하나니까 전부 자기자신을 가르킬 수 있도록 함.
            this.head = newNodeBi;
            this.tail = newNodeBi;
            newNodeBi.next = newNodeBi;
            newNodeBi.prev = newNodeBi;
        } else if (beforeData == null) { // 가장 끝 노드를 찾아서 해당 노드를 추가
            NodeBi newNodeBi = new NodeBi(data, this.head, this.tail); // 새롭게 추가할 노드 생성. next는 head, prev는 tail (원형 연결이라)
            this.tail.next = newNodeBi; // 기존의 가장끝 다음에 노드를 넣어줌
            this.head.prev = newNodeBi; // 기존헤드의 이전은 처음에서 다시 돌아가 끝을 가르키도록 만듦
            this.tail = newNodeBi; // tail을 방금 들어온 애가 될 수 있도록 이전.
        } else { // beforeData에 어떤 데이터가 들어왔을때 처리하는 방법
            NodeBi cur = this.head;
            NodeBi pre = cur;
            do {
                if (cur.data == beforeData) {
                    if (cur == this.head) { // 가장 head의 앞에 데이터를 추가
                        NodeBi newNodeBi = new NodeBi(data, this.head, this.tail); // next는 head를, prev는 tail로 원형연결
                        this.tail.next = newNodeBi; // tail의 next도 방금만든 node 가 들어올 수 있도록 변경
                        this.head.prev = newNodeBi; // head의 이전도 방금만든 node
                        this.head = newNodeBi; // head는 맨처음에 들어왔으니까 방금들어온애로 변경.
                    } else { // Node가 중간에 추가되는 경우
                        NodeBi newNodeBi = new NodeBi(data, cur, pre); // 노드를 만들때 next는 cur, 이전은 pre
                        pre.next = newNodeBi; // pre의 next는 중간에 들어올 노드를 가리킴
                        cur.prev = newNodeBi; // 기존의 beforedata에 담았던 노드의 이전
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while (cur != this.head);
        }
    }


    //  연결 리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeBi cur = this.head;
        NodeBi pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) { // 노드가 하나뿐
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) { // 노드가 head
                    cur.next.prev = this.head.prev; // 현재 삭제하려는 노드의.그다음노드의.이전링크를 = 지금 이 헤드의. 이전으로 가르키게 변경
                    // -기존헤드 삭제, 그다음 이전은 다시 이전으로 돌아가 tial을 가리킴. this.head.prev 대신 tail로 바꿔도 무방하다.
                    this.head = cur.next; // 원래 head를 지울거니까 next로 변경
                    this.tail.next = this.head; // 기존 tial의 next는 원래지우려고 햇었던 대상에서 이제 바뀌는 head로 변경
                } else if (cur == this.tail) { // 노드가 tail (가장 끝노드를 삭제)
                    pre.next = this.tail.next; // 그 이전 노드의 next를 = 이 끝노드의 다음으로 링크변경
                    this.tail = pre; // tail을 가장 끝의 이전인 pre로 변경
                    this.head.prev = this.tail; // 맨앞 head의 이전노드는 = 변경된 tail로 연결
                } else { // 노드가 중간
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }
    // 출력을 위한 메소드
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        NodeBi cur = this.head;
        while (cur.next != this.head){ // null이 아닐때까지 반복하면 무한루프. 원형구조라 다시 자기자신이 되지 않을때까지 반복문 돌림.
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println(cur.data); // 가장 끝노드 출력으로 마무리.
    }

}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        CircularLinkedList myList = new CircularLinkedList(new NodeBi(1, null, null));
        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();  // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();  // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
    }
}
