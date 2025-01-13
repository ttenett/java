// Practice2
// 해시 충돌 해결 - 개방 주소법 (선형 탐사법)

class MyHashTable2 extends MyHashTable {

    MyHashTable2(int size) {
        super(size);
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is full!");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else { // 공간 잇는데 null이 아닌 다른 데이터가 들어있는 경우. 충돌발생지점
            int newIdx = idx; // 기존에 얻은 해시위치부터. 충돌난 지점부터
            while (true) { // 반복문을 통해 빈공간 찾을때까지
                newIdx = (newIdx + 1) % this.table.length; // 하나씩 증가시키면서 테이블 뺑뺑이 돔
                if (this.table[newIdx] == null) { // 빈공간 찾음
                    break;
                }
            }
            this.table[newIdx] = data; // 해당 위치에 데이터 넣어줌
        }
        elemCnt++;
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyHashTable2 ht = new MyHashTable2(5);
        ht.setValue(1, 1);
        ht.setValue(3, 3);
        ht.printHashTable();

        ht.setValue(1, 10);
        ht.printHashTable(); // 1다음 빈공간에 10이 들어감.

        ht.setValue(1, 20);
        ht.setValue(1, 30); // 데이터 2개 더 넣고나면 해시테이블 공간이 가득 참.
        ht.setValue(1, 40);
        ht.printHashTable();
    }
}
