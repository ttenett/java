// 선형 자료구조 - 스택

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        // peek은 가장 마지막에 들어간 연산을 보여주고, 빼지는 않음.
        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.contains(1));
        System.out.println(stack.size()); // 3
        System.out.println(stack.empty()); // 비어있는지 여부 확인

        // 모든 데이터 지우고
        stack.clear();
        System.out.println(stack);
        stack.pop(); // 비어있는 상태에서 pop하면 에러발생.
        // EmptyStackException, 예외처리 해주든, stack데이터가 없으면 pop을 할 수 없도록 조건문 작성하든 조치 필요.

    }

}
