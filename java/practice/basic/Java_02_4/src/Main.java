// Java 프로그래밍 - 변수와 자료형_4

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//      1. 자료형 - 리스트
        System.out.println("== 리스트 ==");
        ArrayList l1 = new ArrayList();

//      1-1. add
        l1.add(1);
        l1.add("hello");
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add("world!");
        System.out.println("l1 = " + l1); // l1 = [1, hello, 2, 3, 4, world!]

        l1.add(0, 1);        // 어느 위치에, 어떤 값을 넣을 건지
        System.out.println("l1 = " + l1); // l1 = [1, 1, hello, 2, 3, 4, world!]

//      1-2. get
        System.out.println(l1.get(0));    // 1
        System.out.println(l1.get(3));    // 2

//      1-3. size - 리스트의 원소 개수, 데이터의 개수 몇개인지 알려줌
        System.out.println(l1.size());    // 7

//      1-4. remove
        System.out.println(l1.remove(0));  // l1 = [1, hello, 2, 3, 4, world!]
        System.out.println("l1 = " + l1);

//      인덱스가 아닌 값을 지우고 싶다면? 리스트의 '2' 값을 찾아서 지우기
        System.out.println(l1.remove(Integer.valueOf(2)));
        System.out.println("l1 = " + l1);       // l1 = [1, hello, 3, 4, world!]

//      1-5. clear - 리스트의 모든 데이터를 제거
        l1.clear();
        System.out.println("l1 = " + l1);       // l1 = []

//      1-6. sort - 내림/오름차순 정렬
        ArrayList l2 = new ArrayList();
        l2.add(5);
        l2.add(3);
        l2.add(4);
        System.out.println("l2 = " + l2);       // l2 = [5, 3, 4]

        l2.sort(Comparator.naturalOrder());     // l2 = [3, 4, 5]
        System.out.println("l2 = " + l2);
        l2.sort(Comparator.reverseOrder());     // l2 = [5, 4, 3]
        System.out.println("l2 = " + l2);

//      1-7. contains - 데이터가 리스트에 들어있는지 체크
        System.out.println(l2.contains(1));     // false
        System.out.println(l2.contains(3));     // true


//      2. Maps - {'a = b'}쌍을 이뤄서 저장하는 자료형.
//      순서가 보장되지(중요하지) 않음. 데이터를 액세스할 때, 배열이나 리스트처럼 인덱스로 접근하는게 아니라 왼쪽 키값으로 접근.
        System.out.println("== Maps ==");
        HashMap map = new HashMap();

//      2-1. put - 데이터를 넣는 방법
        map.put("kiwi", 9000);
        map.put("apple", 10000);
        map.put("mango", 12000);
        System.out.println("map = " + map);     // map = {apple=10000, kiwi=9000, mango=12000}
        
//      2-2. get - 데이터를 꺼내오는 방법
        System.out.println(map.get("mandarine")); // null : 값이 없음.
        System.out.println(map.get("kiwi"));      // 9000

//      2-3. size
        System.out.println(map.size());         // 3

//      2-4. remove - 지우면서 해당 값을 되돌려 줌
        System.out.println(map.remove("kiwi"));     // 9000
        System.out.println(map.remove("mandarine"));// null
        System.out.println("map = " + map);

//      2-5. containsKey - 해당 키 값이 맵에 있는지 확인
        System.out.println(map.containsKey("apple"));   // true
        System.out.println(map.containsKey("kiwi"));    // false

        
//      3. Generics - 자료형을 제한해주는 기능
        System.out.println("== Generics ==");
        ArrayList l3 = new ArrayList();
        l3.add(1);
        l3.add("hello");
        System.out.println("l3 = " + l3);               // l3 = [1, hello]

        ArrayList<String> l4 = new ArrayList<String>(); // 객체에<>만 써도 되는데 명시해줌!
//      l4.add(1);
        l4.add("hello");
        System.out.println("l4 = " + l4);               // l4 = [hello]

        // 제네릭으로 제한 없/있 HashMap
        HashMap map1 = new HashMap();
        map1.put(123, "id");
        map1.put("apple", 10000);
        System.out.println("map1 = " + map1);   // map1 = {apple=10000, 123=id}

        HashMap<String, Integer> map2 = new HashMap<>();
//      map2.put(123, "id"); 오류남
        map2.put("apple", 10000);
        System.out.println("map2 = " + map2);   // map2 = {apple=10000}
    }

}
