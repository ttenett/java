// Practice4
// 해시 충돌 해결 - 개방 주소법 (이중 해싱)

class MyHashTable4 extends MyHashTable {
    int c;

    MyHashTable4(int size) {
        super(size);
        this.c = this.getHashC(size);
    }

    // 해시테이블보다 조금작은 소수. 반드시 이렇게 해야하는건 아님. this.c 에 임의의 배열 사이즈값 넣어줘도 가능.
    // 할당한 배열 사이즈값보다 작으면 됨
    public int getHashC(int size) {
        int c = 0;

        if (size <= 2) { // 그냥 소수니 바로 리턴
            return size;
        }
        // 2보다 큰 수 들어왔을때. 소수 = 1과 자기자신으로만 나눠지는 수
        for (int i = size - 1; i > 2; i--) {
            boolean isPrime = true; // 소수인지 아닌지 판별하는 변수
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                c = i;
                break;
            }
        }
        return c;
    }

    // 두번째 해시함수를 구하기 위한 메소드
    public int getHash2(int key) {
        int hash = 1 + key % this.c; // 어떤 c값으로 나눈 나머지에 +1. 일반적인 이중해싱의 기본적 형태
        //this.c 보통 여기에 나오는 값은 해시테이블의 사이즈보다 조금 작은 소수임. 그래야 효율적인 효과를 냄.
        return hash;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is full!");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else { // 충돌났을때 얼만큼 움직이기 위한 값을 구할때 두번째 해시함수를 이용
            int newIdx = idx; // 충돌지점 잡아줌
            int cnt = 1;
            while (true) {
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;

    }

}
public class Practice4 {
    public static void main(String[] args) {
        // Test code
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();


        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }
}
