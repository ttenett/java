// Practice1
// 해시 테이블 배열로 직접 구현

class MyHashTable {
    Integer[] table; // 배열 생성
    // 해시테이블 안에 실질적으로 데이터가 몇개들어있는지 체크
    int elemCnt;

    MyHashTable() {} // 기본생성자, practice2, 3, 4에서도 사용할예정
    MyHashTable(int size) {
        this.table = new Integer[size];
        this.elemCnt = 0; // 초기화
    }

    public int getHash(int key) {
        return key % this.table.length;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key); // 인덱스 해시값을 구함. 키값을 넣어서 해시값을 뽑아냄.
        // 해시에 해당하는 위치에 데이터 넣어주기
        this.table[idx] = data;
        this.elemCnt++;
        // 아직 충돌하는 경우는 고려하지 않겠음.
    }

    public int getValue(int key) {
        int idx = this.getHash(key);
        return this.table[idx];
    }

    public void removeValue(int key) {
        int idx = this.getHash(key); // 키값을 받아서 해당 해시값을 구함
        this.table[idx] = null; // 해시에 해당하는 데이터를 null로 변경
        this.elemCnt--; // 카운트는 하나 빼줌
    }
    // 해시테이블 출력
    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.println(i + ": " + this.table[i]);
        }
    }


}

public class Practice1 {

    public static void main(String[] args) {
        // Test code
        MyHashTable ht = new MyHashTable(7);
        ht.setValue(1, 1);
        ht.setValue(2, 2);
        ht.setValue(3, 3);
        ht.setValue(4, 4);
        ht.setValue(5, 5);
        ht.printHashTable();
        ht.setValue(8, 6);
        ht.printHashTable();
    }
}
