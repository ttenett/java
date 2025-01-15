// 기초 수학 - 집합

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

//      1. 자바에서 집합 사용 - HashSet
        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.println("set1 = " + set1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        // 데이터 삭제시 인덱스가 아니라 값이 들어감.
        set1.remove(1);
        System.out.println("set1 = " + set1);
        System.out.println(set1.size());
        System.out.println(set1.contains(2));
        

//      2. 집합 연산
        System.out.println("== 집합 연산 ==");

//      2-1. 교집합
        HashSet a = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet b = new HashSet(Arrays.asList(2, 4, 6, 8, 10));
        // b와 교집합 원산을 통해 공통원소만 a에 남는다.
//        a.retainAll(b);
//        System.out.println("교집합: " + a);


//      2-2. 합집합
//        a.addAll(b);
//        System.out.println("합집합: " + a);


//      2-3. 차집합
        a.removeAll(b);
        System.out.println("차집합: " + a);

        // 프로그래밍관점에서는 연습이 안되니까, HashMmap을 사용하지 않고 Practice에서 구현해보기로.


    }

}
