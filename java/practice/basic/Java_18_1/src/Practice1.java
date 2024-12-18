import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice1 {
    public static void solution(int num) {
        int numReverse = 0; // 값을 거꾸로 뒤집어서 결과로 저장할 변수
        boolean isMinus = false; // 마이너스 체크

        if (num < 0) {
            isMinus = true;
            num *= -1;
        }

        while (num > 0) {
            int r = num % 10; // 10으로 나눈 나머지 한자리씩 떼옴
            num /= 10; // 그다음 연산을 위해 10으로 나눈 몫을 세팅
            numReverse = numReverse * 10 + r;

        }
        System.out.println(isMinus ? numReverse * -1 : numReverse);


    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }

    //Scanner sc = new Scanner(System.in);
//    InputStreamReader reader = new InputStreamReader(System.in);
//    reader.read(a);
//    //int[] nums = sc;
//    int[] a;
//    int num;
//    int i = 0;
//    for (i = 0; i < a.length(); i++;) {
//        nums = num % 10
//    }
}
