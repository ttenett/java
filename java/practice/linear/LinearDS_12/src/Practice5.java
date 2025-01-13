// Practice5
// 해시 충돌 해결 - 분리 연결법
// 기본연결리스트 구조를 이용하면 비교적 간단하게 구현 가능. 분리연결법은 충돌 여부를 크게 개의치 않고
// 해당 위치 연결리스트에다가 addData로 뒤에 쭉쭉 연결해주면 됨.

class Node {
    int key; // 키와 데이터 둘다 저장하기 위함
    int data;
    Node next;

    Node() {}
    Node(int key, int data, Node next) {
        this.key = key;
        this.data = data;
        this.next = next;
    }
}

class LinkedList { // 단방향연결리스트 코드
    Node head;

    LinkedList() {}
    LinkedList(Node node) {
        this.head = node;
    }

    public boolean isEmpty() {
        // return this.head == null;
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int key, int data) {
        if (this.head == null) {
            this.head = new Node(key, data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(key, data, null);
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.key == data) { // 키값 기준으로 데이터 삭제
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public Integer findData(int key) { // 찾은 데이터 반환할 수 있도록 타입변경
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.key == key) { // 키값 기준
                System.out.println("Data exist!");
                return cur.data; // 찾은 해당 데이터 반환
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
        return null;
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
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

class MyHashTable5 {
    LinkedList[] table;

    MyHashTable5(int size) {
        this.table = new LinkedList[size];
        for (int i = 0; i < this.table.length; i++) {
            // 우선 헤드가 아무것도 가르키는게 없는 상태로 테이블에 연결리스트 객체 만들어줌
            this.table[i] = new LinkedList(null);
        }
    }
    // 해시값 구하는 연산은 기본디폴트
    public int getHash(int key) {
        return key % this.table.length;
    }

    public void setValue(int key, int data) {
        // 키값 기준으로 해시값 가져옴
        int idx = this.getHash(key);
        // 그 위치에 데이터 넣어줌. 데이터 넣을땐 해당 배열의 연결리스트 위치에 있는곳으로 가서 addData
        // addData시 키와 데이터 쌍으로 넣어줌
        this.table[idx].addData(key, data);
    }

    public int getValue(int key) {
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }

    public void removeValue(int key) {
        int idx = this.getHash(key);

        this.table[idx].removeData(key);
    }

    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.print(i + ": ");
            this.table[i].showData();
        }
    }
}

public class Practice5 {
    public static void main(String[] args) {
        // Test code
        MyHashTable5 ht = new MyHashTable5(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();
        ht.setValue(12, 11);
        ht.setValue(23, 12);
        ht.setValue(34, 13);

        ht.setValue(13, 21);
        ht.setValue(24, 22);
        ht.setValue(35, 23);

        ht.setValue(5, 1);
        ht.setValue(16, 2);
        ht.setValue(27, 3);
        ht.printHashTable();

        System.out.println("== key 값으로 해당 데이터 가져오기 ==");
        System.out.println(ht.getValue(1));
        System.out.println(ht.getValue(12)); // 1값

        System.out.println("== 데이터 삭제 ==");
        ht.removeValue(1);
        ht.removeValue(5);
        ht.removeValue(16); // 16번째값 5번의 2가 지워질 차례
        ht.printHashTable();

    }
}
