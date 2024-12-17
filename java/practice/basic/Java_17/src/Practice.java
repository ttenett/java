// Practice
// 하기 예제를 스트림으로 구현해보세요.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {

        // 예제: 1~10 숫자 중 짝수 들의 합
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;

        for (int num: arr) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        System.out.println("sum = " + sum);


        // 스트림으로 구현

        //Stream<Integer> stream = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).stream();
        IntStream stream = IntStream.range(1, 11).filter(n -> n % 2 == 0);
        int summ = stream.sum();
        System.out.println("summ = " + summ);

        // 강사님
        int sum2 = IntStream.rangeClosed(1, 10).filter(x -> x % 2 == 0).sum();
        System.out.println("sum2 = " + sum2);

    }
}
