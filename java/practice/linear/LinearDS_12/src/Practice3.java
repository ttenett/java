// Practice3
// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)

class MyHashTable3 extends MyHashTable {

    MyHashTable3(int size) {
        super(size);
    }

    public void setValue(int key, int data) { // 오버라이딩
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is full!!");
            return;
        } else if (this.table[idx] == null) { //해당위치가 null일 경우
            this.table[idx] = data; // 바로 이 위치에 데이터 입력
        } else { // 충돌 난 상황에서 제곱탐사법 이용. n²만큼 점점 증가시키면서 서치하는 인덱스 구하면 됨
            int newIdx = idx; // 충돌난 지점으로 초기화
            int cnt = 0; //충돌이 계속해서 몇번 났는지 카운트
            while (true) {
                newIdx = (newIdx + (int)Math.pow(2, cnt)) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                cnt++; // 충돌이 났을때마다 카운트 증가
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;

    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100); // 데이터 충돌 남. 2의0승만큼 이동. 한칸이동 -> 2의1승(2칸)이동
        // -> 2의2승만큼 이동 -> 8번에 100을 넣음.
        ht.printHashTable();

        ht.setValue(1, 200); // 1 - 2 - 4 - 8칸이동=나머지연산해서 5번위치에 200들어감.
        ht.setValue(1, 300); // 2의4승 = 16번 > 10번위치에 들어감.
        ht.setValue(1, 400);
        ht.printHashTable();
    }
}
