// 선형 자료구조 - 해시 테이블

import java.util.Hashtable;
import java.util.Map;

public class Main {
    // 해시 함수
    public static int getHash(int key) {
        return key % 5; // hashtable의 사이즈
    }


    public static void main(String[] args) {
        // 기본 해시 테이블 사용 방법
        Hashtable<String, Integer> ht = new Hashtable();

        ht.put("key1", 10);
        ht.put("key2", 20);
        ht.put("key3", 30);
        ht.put("key3", 50);

        // for each문 출력. ht테이블 안에 있는 키값 대응되는 데이터의 entry들을 쭉 뽑아줌. foreach 문에서 받기 위해 타입을 맞춰줌.
        // 타입 맞출때 해쉬테이블은 Map 인터페이스를 통해서 만듬.
        for (Map.Entry<String, Integer> item: ht.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
            // 해시테이블 -> 키밸류 쌍으로 들어있음. 순서는 의미 없음. 각각 키에 대응되는 데이터들이 잘 들어가 있음.
            // 해시를 구한게 아니라, 바로 키값을 통해서 해시테이블 구조에다가 데이터를 넣어준 형태임.
            // 굳이 충돌을 만들어 본다면, 똑같은 키값3에 데이터 50을 넣는다면? -> 해당 키의 데이터가 변경됨.
        }

        // 해시 충돌 케이스 (해시 함수 사용)
        Hashtable<Integer, Integer> ht2 = new Hashtable();
        // put에 키를 바로 쓰지않고, gethash에 키를 넣어서 반환되는 해시값을 이용해 데이터를 넣어보기
        ht2.put(getHash(1), 10);
        ht2.put(getHash(2), 20);
        ht2.put(getHash(3), 30);
        ht2.put(getHash(4), 40);
        ht2.put(getHash(5), 50);

        System.out.println("== 충돌 전 == ");
        for (Map.Entry<Integer, Integer> item: ht2.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
            // hashfunction이 key를 5로 나눈 나머지이기 때문에 0번쪽에 50이 들어감.
        }

        System.out.println("== 충돌 후 == ");
        ht2.put(getHash(6), 60);
        for (Map.Entry<Integer, Integer> item: ht2.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
            // 1이라는 위치에 60이 들어감. 기존 데이터가 사라짐.
        }



    }
}
