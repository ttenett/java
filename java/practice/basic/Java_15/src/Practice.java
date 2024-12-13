// Practice
// 컬렉션의 set으로 로또 번호 만들기

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Practice {
    public static void main(String[] args) {
        HashSet lotto = new HashSet();

        for (int i = 0; lotto.size() < 6; i++) {
            // 0~44 까지의 랜덤데이터가 나옴.. +1 해주면 됨.
            int num = (int)(Math.random() * 45) + 1;
            lotto.add(num);
        }

        LinkedList list = new LinkedList(lotto);
        Collections.sort(list);
        System.out.println("로또 번호: " + list);
    }
}
