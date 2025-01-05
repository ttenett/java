// Practice1
// 문자열 뒤집기

// 입출력 예시)
// 입력: "Hello"
// 출력: "OlleH"

// 입력: 1 3 5 7 9
// 출력: 9 7 5 3 1

import java.util.Stack;

public class Practice1 {
    public static String reverseString(String str) {
        Stack stack = new Stack();
//        내가 적은 코드
//        stack.push(str);
//
//        for (int i = 0; i < str.length(); i++) {
//            // 리턴한거만큼 배열에 담아야하나
//             result = stack.pop();
//        }
        String result = "";
//      한글자씩 뜯어서 반복문으로 가져옴
        for (String s: str.split("")) {
            stack.push(s);
        }

//      반복문 탈출조건 - 아무것도 없는 스택에서 팝을하면 에러가 남.
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);
    }
}
