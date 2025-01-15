// Practice
// ArrayList를 사용한 집합 구현 실습 (집합 관련 연산 사용 X)

import java.util.ArrayList;

class MySet {
    // 집합을 위한 기능들 추가
// ArrayList - 멤버변수 Integer타입으로 List가 잡혀있음.
    ArrayList<Integer> list;

// 생성자1 - 객체를 만들어줌
    MySet() {
        this.list = new ArrayList<Integer>();
    }

// 생성자 2 - 데이터를 만들어서 객체를 만들때 데이터를 넣어줌.
    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();

        for (int item: arr) {
            this.list.add(item);
        }
    }

// 원소 추가 (중복 X)
    public void add(int x) {
        // list와 add 데이터 비교, 같으면 추가 하지 않음. return으로 함수를 벗어남.
        for (int item: this.list) {
            if (item == x) {
                return;
            }
        }
        // for 문을 도는 동안 같은값이 발견되지 않았다면 추가
        this.list.add(x);
    }


// 교집합,
// HashSet의 교집합은 a.retainAll(b)하면 a의 집합 내용이 바뀌는데, 우리는 a의 내용은 그대로 두고, 교집합된 집합을 새로 반환하는 함수 만들어보기
    public MySet retainAll(MySet b) {
        MySet result = new MySet();

        // 자기 자신의 list를 순회하고, 새로 들어온 집합을 순회하면서 비교하는 구문
        for (int itemA: this.list) {
            for (int itemB: b.list) {
                if (itemA == itemB) {
                    result.add(itemA); // 공통된 데이터들만 원소 추가
                }
            }
        }
        return result;
    }


// 합집합
    public MySet addAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            result.add(itemA);
        }

        for (int itemB: b.list) {
            result.add(itemB);
        }
        return result;
    }


// 차집합
    public MySet removeAll(MySet b) {
        // 반환을 위한 새로운 자료형
        MySet result = new MySet();

        // 현재집합의 리스트 순회
        for (int itemA: this.list) {
            boolean containFlag = false;
            // 차집합 하려는 리스트 순회
            for (int itemB: b.list) {
                if (itemA == itemB) {
                    // 같은 원소가 있는지 없는지 구분하는 flag
                    // 순회를 하다가 같은값을 찾았으면 남은 원소를 순회하지 않아도 되니까 구문 탈출시킴.
                    containFlag = true;
                    break;
                }
            }
            // false면, 두리스트에 같은값이 없다. a-b에서 살아남는 원소가 리턴이 됨.
            if (!containFlag) {
                result.add(itemA);
            }
        }
        return result;
    }
}

public class Practice {
    public static void main(String[] args) {

//      Test code
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list);

        result = a.addAll(b);
        System.out.println("합집합: " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list);
    }
}
