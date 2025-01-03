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
        Stack<Double> stack = new Stack();
//        int num1, num2, answer = 0;
//         // 내가 쓴 코드 " " 공백 기준으로 split 해라. 이건 맞음. 근데 foreach에 쓰는게 다르네
//         for (String s: string.split(" ")) {
//             // 들어오는 문자 2개 stack에 쌓기. 아니면 연산자 나올때까지
//             // 숫자형은 push, 문자형은 pop을 하는 방식으로 해야하나?? for문은 다 문자형인데
//             // push를 2번, 문자형 연산자, pop 2번 연산진행을 반복함.
//             stack.push(s);
//             stack.push(s);
//
//             // 연산자가 들어왔을 때, 직전 push문자 꺼내기(음수들어왔으면 음수 붙이기) 숫자로 변환
//             if (s.equals("+")) {
//                 num1 = (int) stack.pop();
//                 num2 = (int) stack.pop();
//                 String result = String.valueOf(num1 + num2);
//                 result += answer;
//                 stack.push(result);
//             } else if (s.equals("-")) {
//                 // 마이너스를 먼저 나온 숫자에 어케붙이지?
//                 num1 = (int) stack.pop();
//                 num2 = (int) stack.pop();
//                 String result = String.valueOf(num2 - num1);
//                 result += answer;
//                 stack.push(result);
//             } else if (s.equals("*")) {
//                 num1 = (int) stack.pop();
//                 num2 = (int) stack.pop();
//                 String result = String.valueOf(num1 * num2);
//                 result += answer;
//                 stack.push(result);
//             } else if (s.equals("/")) {
//                 num1 = (int) stack.pop();
//                 num2 = (int) stack.pop();
//                 String result = String.valueOf(num1 / num2);
//                 result += answer;
//                 stack.push(result);
//             } else {
//                 if (stack.isEmpty()) {
//                     break;
//                 }
//             }
//         } // 결과들을 어떻게 pop을 시키지? 모두 더해주는 변수를 만들어서 리턴..?
//         return answer; -> ClassCastException 오류가 난다ㅜ

        // 강의 정답. 오 그래도 접근법이 아예 다른건 아니네. 이런방법으로 코드를 쓰면되는구나
            for (String str: string.split(" ")) {
                if (str.equals("+")) {
                    // object 끼리는 연산이 불가해서 빨간줄이 생김. 제네릭을 쓰거나, 형변환을 매번 시켜주면 된다.
                    // stack.push((double)stack.pop() + (double)stack.pop());
                    stack.push(stack.pop() + stack.pop());
                } else if (str.equals("-")) {
                    stack.push(- stack.pop() + stack.pop());
                } else if (str.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (str.equals("/")) {
                    // 왜 stack.pop() / stack.pop()을 안하고 1로 나눠준다음 곱하지? -> 결과가 다르게 나오긴 한다.
                    stack.push(1 / stack.pop() * stack.pop());
                } else {
                    // 연산자가 아닌 일반숫자들은 push로 넣어줌. 각각 글자는 string이므로 double로 형변환해줌.
                    stack.push(Double.parseDouble(str));
                }
            }
            return stack.pop();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(calculate("2 2 +"));    // 4
        System.out.println(calculate("2 2 -"));    // 0
        System.out.println(calculate("2 2 *"));    // 4
        System.out.println(calculate("2 2 /"));    // 1

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14

    }
}
