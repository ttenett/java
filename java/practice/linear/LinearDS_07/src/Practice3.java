// Practice3
// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class Practice3 {
    public static double calculate(String string) {
        Stack stack = new Stack();
        int num1, num2, answer = 0;

         for (String s: string.split(" ")) {
             // 들어오는 문자 2개 stack에 쌓기. 아니면 연산자 나올때까지
             // 숫자형은 push, 문자형은 pop을 하는 방식으로 해야하나?? for문은 다 문자형인데
             // push를 2번, 문자형 연산자, pop 2번 연산진행을 반복함.
             stack.push(s);
             stack.push(s);

             // 연산자가 들어왔을 때, 직전 push문자 꺼내기(음수들어왔으면 음수 붙이기) 숫자로 변환
             if (s.equals("+")) {
                 num1 = (int) stack.pop();
                 num2 = (int) stack.pop();
                 String result = String.valueOf(num1 + num2);
                 result += answer;
                 stack.push(result);
             } else if (s.equals("-")) {
                 // 마이너스를 먼저 나온 숫자에 어케붙이지?
                 num1 = (int) stack.pop();
                 num2 = (int) stack.pop();
                 String result = String.valueOf(num2 - num1);
                 result += answer;
                 stack.push(result);
             } else if (s.equals("*")) {
                 num1 = (int) stack.pop();
                 num2 = (int) stack.pop();
                 String result = String.valueOf(num1 * num2);
                 result += answer;
                 stack.push(result);
             } else if (s.equals("/")) {
                 num1 = (int) stack.pop();
                 num2 = (int) stack.pop();
                 String result = String.valueOf(num1 / num2);
                 result += answer;
                 stack.push(result);
             } else {
                 if (stack.isEmpty()) {
                     break;
                 }
             }
         }
         return answer;

    }

    public static void main(String[] args) {
        // Test code
        System.out.println(calculate("2 2 +"));    // 4
//        System.out.println(calculate("2 2 -"));    // 0
//        System.out.println(calculate("2 2 *"));    // 4
//        System.out.println(calculate("2 2 /"));    // 1
//
//        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
//        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14

    }
}
