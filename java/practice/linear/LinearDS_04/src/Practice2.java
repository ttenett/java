// Practice2
// 양방향 연결 리스트 (Doubly Linked List) 구현

class NodeBi {
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(int data, NodeBi next, NodeBi prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedList {
    // 가지고 있는 노드들 중 가장 처음 head, 끝 tail 으로 관리
    NodeBi head;
    NodeBi tail;

    // 생성자. node가 만들어져서 객체가 생성되는 경우 처음엔 head와 tail이 같은 node를 가르킴
    DoublyLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
    }

    // isEmpty 는 상속받은 부모도 있는데, 관리하는 노드의 타입이 변경되어 새롭게 만들어줌
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) { // node가 아무것도 없을 때
            // NodeBi 객체를 새로 생성
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        } else if (beforeData == null) { // 이전 구현은 cur와 따라오는 prev로 구현, 지금은 tail로 바로 추가 가능
            this.tail.next = new NodeBi(data, null, this.tail); // prev 이전 노드는 기존의 tail을 가르킴
            this.tail = this.tail.next;
        } else {
            NodeBi cur = this.head;  // 찾을 대상
            NodeBi pre = cur;        // 그 이전노드를 따라다니기 위한 pre
            while (cur != null) {
                if (cur.data == beforeData) { // 해당 노드를 찾았을때, 데이터 추가
                    if (cur == this.head) {   // 찾은 노드가 맨처음인 헤드라면 아래 코드 실행.
                        this.head = new NodeBi(data, this.head, null); // 기존 헤드를 새롭게 만드는 노드를 가르키도록함. next가 이전의 head 가리킴
                        this.head.next.prev = this.head; // 이 head의 next를 다시 가서 그 prev를 바뀐 head로 만들어줌.
                    } else { // 헤드가 아닐 때
                        pre.next = new NodeBi(data, cur, pre); // 중간에 데이터가 추가되는 경우
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) { // cur가 head, tail과 같음. 노드가 하나인 케이스
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) { // head 이고 노드가 하나가 아닌 상황.
                    this.head = cur.next; // head를 다음으로 가르키도록. 이전은 null
                    this.head.prev = null;
                } else if (cur == this.tail) { // 찾은 노드가 가장 끝인 경우
                    this.tail = this.tail.prev; // 가장 끝을 가르키던 tail을 기존tail로 이전.
                    this.tail.next = null;
                } else { // 중간노드 삭제
                    pre.next = cur.next;
                    cur.next.prev = pre; // 원래는 삭제대상인 노드를 가르키고 있을 prev에 pre가 되도록. 중간노드 사라짐.
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        // 리스트순회, 데이터 모두 출력시키는 기본출력 메소드
        NodeBi cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 끝에서부터 역순으로 출력
    public void showDataFromTail() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        // 역순은 tail로부터 시작. 양방향 링크를 이용해 출력
        NodeBi cur = this.tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
}



public class Practice2 {
    public static void main(String[] args) {

//      Test code
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData();          // 1

        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();          // 100 1 200 2 300 3 400 4 500 5
        myList.showDataFromTail();  // 5 500 4 400 3 300 2 200 1 100

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
        myList.showDataFromTail();  // List is empty!
    }
}
