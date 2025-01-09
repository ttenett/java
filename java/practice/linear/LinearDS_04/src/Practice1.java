// Practice1
// 단순 연결 리스트 구현 완성
// 중간에서도 추가, 삭제가 이루어지도록 완성해보기

class LinkedList2 extends LinkedList {

    LinkedList2(Node node) {
        // 자기자신에 변수가 없음. 부모클래스의 멤버변수에 할당.
        this.head = node;
    }

    // 연결리스트에 데이터 추가
    // before_data가 null인 경우, 가장 뒤에 추가
    // before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
            Node cur = this.head;
            while (cur.next != null) { // 반복문 돌며 cur.next가 없을때까지 이동
                cur = cur.next;
            }
            // 가장 끝 노드 뒤에 방금 들어온 데이터를 노드로 만들어서 할당
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node pre = cur;
            while (cur != null) {
                // cur.data(각각의 노드 데이터)가 매개변수로 들어온 beforeData가 같은 경우, 추가
                if (cur.data == beforeData) { // 연결리스트 내에서 beforeData를 가진 노드를 찾음
                    if (cur == this.head) { // 만약 cur가 head일 경우
                        this.head = new Node(data, this.head); // head에 방금들어온 데이터를 노드로만들어 할당
                        // 신경써줘야 할 부분: 새로운 노드의 다음노드는 , 이전 헤드노드로 만들어줘야 함.
                    } else { // 그외에 중간에 들어가는 경우
                        // 노드를 새로 만들어서 pre.next에 만들어줌. 다음 노드는 cur로 만들어주기.
                        pre.next = new Node(data, cur);
                    }
                    break;
                }
                // cur이동, pre는 cur 하나 앞을 따라다님.
                pre = cur;
                cur = cur.next;
            }
        }
    }
    // removedata
    public void removeData(int data) {
        // 부모클래스의 메소드 isempty 사용
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        // 지울 대상의 노드를 찾을 cur, 하나 앞에 따라다니는 pre
        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data == data) { // 데이터가 맞는지 확인
                if (cur == this.head) { // 헤드를 cur다음으로 바꿔줌
                    this.head = cur.next;
                } else {
                    pre.next = cur.next; // 자기자신을 뛰어넘은 다음노드로 변경
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}


public class Practice1 {
    public static void main(String[] args) {

//      Test code
        LinkedList2 myList = new LinkedList2(new Node(1, null));
        myList.showData();         // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();         // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();         // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();         // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();         // List is empty!
    }
}
