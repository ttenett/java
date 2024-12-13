// Java 프로그래밍 - 컬렉션 프레임워크

import java.util.*;

public class Main {

    public static void main(String[] args) {

//      1. List
//        1-1. ArrayList - 객체 생성, add 메서드로 데이터 추가
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println("list1 = " + list1);
        // 데이터 삭제, 문자는 해당 문자를 바로 씀. 숫자는 인덱스로 인식. 숫자도 데이터로 지우고 싶다면 아래 메서드를 이용.
        list1.remove(Integer.valueOf(2));
        System.out.println("list1 = " + list1); // list1 = [1, 3]
        // add로 넣고자 하는 위치도 지정.
        list1.add(0, 10);
        System.out.println("list1 = " + list1); // list1 = [10, 1, 3]
        // list size 확인
        System.out.println("list1.size() = " + list1.size()); // list1.size() = 3
        // list 해당 값이 들어있는지 확인
        System.out.println("list1.contains(1) = " + list1.contains(1)); // list1.contains(1) = true
        // list의 (10)값의 인덱스의 위치
        System.out.println("list1.indexOf(10) = " + list1.indexOf(10)); //         // list1.indexOf(10) = 0

//      1-2. LinkedList -> 자료구조 파트에서 다시 알아볼 것.
        System.out.println("== LinkedList ==");
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println("list2 = " + list2);
        // 원소 값 추가하기
        list2.addFirst(10);
        list2.addLast(20);
        System.out.println("list2 = " + list2);
        // 데이터 지우기
        list2.remove(Integer.valueOf(1));
        System.out.println("list2 = " + list2);
        list2.removeFirst();
        list2.removeLast();
        System.out.println("list2 = " + list2);
        System.out.println(list2.size());

//      2. Set
//      2-1. HashSet
        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        // 데이터 지우기. 인덱스로 인식하는게 아니라 각수로 인식
        set1.remove(1);
        System.out.println("set1 = " + set1);
        // set은 중복된 데이터를 허용하지 않음.
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        System.out.println(set1.size()); // 2
        System.out.println(set1.contains(2)); // true


//      2-2. TreeSet - 기본 부분은 같은데, 나중에 이용하는 부분에서 차이가 남.
//      바이너리 서치 또는 탐색부분에 특화된 자료구조임.
        System.out.println("== TreeSet ==");
        TreeSet set2 = new TreeSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println("set2 = " + set2);
        // 지울때 각수로 인식
        set2.remove(2);
        System.out.println("set2 = " + set2);
        // 모든 데이터 삭제
        set2.clear();
        System.out.println("set2 = " + set2);
        // set이므로 중복데이터 허용되지 않음.
        set2.add(10);
        set2.add(5);
        set2.add(15);
        set2.add(15);
        System.out.println("set2 = " + set2);
        System.out.println(set2.first());
        System.out.println(set2.last());
        // set에서 10보다 작은 값 출력
        System.out.println(set2.lower(10));
        // set에서 10보다 큰 값 출력
        System.out.println(set2.higher(10));

//      3. Map
//      3-1. HashMap - 키와 데이터가 쌍을 이뤄서 들어가는 컬렉션.
        System.out.println("== HashMap ==");
        HashMap map1 = new HashMap();
        map1.put(1, "kiwi");
        map1.put(2, "apple");
        map1.put(3, "mango");
        System.out.println("map1 = " + map1);

        // 삭제 시 키값을 넣음
        map1.remove(2);
        System.out.println("map1 = " + map1);
        // 꺼내올때도 키값을 적음.
        System.out.println("map1.get(1) = " + map1.get(1));


//      3-2. TreeMap
        System.out.println("== TreeMap ==");
        TreeMap map2 = new TreeMap();
        map2.put(10, "kiwi");
        map2.put(5, "apple");
        map2.put(15, "mango");
        System.out.println("map2 = " + map2);

        // 첫번째와 마지막의 데이터, 키값 출력
        System.out.println(map2.firstEntry());
        System.out.println(map2.firstKey());
        System.out.println(map2.lastEntry());
        System.out.println(map2.lastKey());
        System.out.println(map2.lowerEntry(10));
        System.out.println(map2.higherEntry(10));


    }
}
