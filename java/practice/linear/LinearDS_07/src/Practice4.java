// Practice4
// 두 문자열 비교
// 단, #은 backspace 로 바로 이전의 문자를 삭제하는 기능이라고 가정

// 입출력 예시
// 입력: s1 = "tree", s2 = "th#ree"
// 출력: true

// 입력: s1 = "ab#a", s2 = "aab#"
// 출력: true

// 입력: s1 = "wo#w", s2 = "ww#o"
// 출력: false


import java.util.Stack;

public class Practice4 {

    public static boolean stringCompare(String s1, String s2) {
        Stack stack = new Stack();

//        for (String str: s1.split("")) {
//            if (!str.equals("#")) {
//                stack.push(str);
//            } else {
//                stack.pop();
//                // s1이랑 s2 비교 how..?
//            } for (String str2: s2.split("")) {
//                if (!str.equals("#")) {
//                    stack.push(str);
//                } else {
//                    stack.pop();
//            }
//        }
        String s1After = doBackspace(s1);
        String s2After = doBackspace(s2);
        return s1After.equals(s2After);

    }

    public static String doBackspace(String s) {
        Stack stack = new Stack();
        // 이전에는 split으로 글자 하나씩 뜯음 이번에는 string을 character 타입으로 뜯어오기
        for (char c: s.toCharArray()) {
            if (c == '#' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        // Test code
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2));
    }
}
