// Java 프로그래밍 - 스트림

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//      1. 스트림 생성

//      1-1. 배열 스트림
        System.out.println("== 배열 스트림 == ");
        String[] arr = new String[]{"a", "b", "c"};

        System.out.println("== fori ==");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("== forEach ==");
        for (String item: arr) {
            System.out.println(item);
        }

        System.out.println("== to Stream ==");
        Stream stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);


//      1-2. 컬렉션 스트림
        System.out.println("== 컬렉션 스트림 ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("list1 = " + list1);

        Stream stream2 = list1.stream();
        // foreach같은 최종연산을 만나면 더이상 stream할 수 없고 종료가 됨.
//        stream2.forEach(System.out::println);
        // 다른 형태로 바꿔서 출력도 가능. 각각 순회하는 숫자, 출력하는 포맷을 ()안에 맞춰서 출력함.
        stream2.forEach(num -> System.out.println("num = " + num));

        System.out.println("== to Stream ==");


//      1-3. 스트림 builder
        System.out.println("== 스트림 builder ==");
        Stream streamBuilder = Stream.builder().add(1).add(2).add(3).build();
        streamBuilder.forEach(System.out::println);


//      1-4. 스트림 generate - 람다식처럼 하는데,limit(3)은 "abc"데이터를 그 숫자만큼 반복해서 넣어줌
        System.out.println("== 스트림 generate ==");
        Stream streamGenerate = Stream.generate( () -> "abc" ).limit(3);
        streamGenerate.forEach(System.out::println); // abc abc abc


//      1-5. 스트림 iterate
        // limit만큼 반복, 10은 초깃값. 처음 10출력, 10*2, 20*2 이터레이트 시켜줌.
        System.out.println("== 스트림 iterate ==");
        Stream streamIterate = Stream.iterate(10, n -> n * 2).limit(3);
        streamIterate.forEach(System.out::println); // 10 20 40



//      1-6. 기본 타입 스트림
        System.out.println("== 기본타입 스트림 ==");
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(System.out::println); // 1 2 3 4
        // 1부터 5까지 데이터가 다 나오게 하고싶다면? rangeClosed 사용.


//      2. 스트림 중개 연산

//      2-1. Filtering - 1~9 중 짝수데이터만 출력 : 조건에 맞는 애들로 필터링해서 데이터를 솎아내줌.
        System.out.println("== Filtering ==");
        IntStream intStream2 = IntStream.range(1, 10).filter(n -> n % 2 == 0);
        intStream2.forEach(System.out::println); // 2 4 6 8


//      2-2. Mapping - 각각의 원소들을 연산해서 다시 만들어 줌.
        System.out.println("== Mapping ==");
        IntStream intStream3 = IntStream.range(1, 10).map(n -> n + 1);
        intStream3.forEach(n -> System.out.print(n + " ")); // 2 3 4 5 6 7 8 9 10
        System.out.println();


//      2-3. Sorting
        System.out.println("== Sorting ==");
        IntStream intStream4 = IntStream.builder().add(5).add(1).add(3).add(4).add(2).build();
        IntStream intStreamSort = intStream4.sorted();
        intStreamSort.forEach(System.out::println); // 1 2 3 4 5 로 정렬됨.



//      3. 최종 연산

//      3-1. Sum, Average
        System.out.println("== sum, average ==");
        int sum = IntStream.range(1, 5).sum();
        System.out.println("sum = " + sum);
        double average = IntStream.range(1, 5).average().getAsDouble();
        System.out.println("average = " + average);


//      3-2. Min, Max
        System.out.println("== min, max ==");
        int min = IntStream.range(1, 5).min().getAsInt();
        System.out.println("min = " + min);
        int max = IntStream.range(1, 5).max().getAsInt();
        System.out.println("max = " + max);


//      3-3. reduce
        // 연쇄적으로 합을 해서 데이터를 뽑아낼 때 쓰는 스트림. 1+2->3+3->6+4->10+5->15
        System.out.println("== reduce ==");
        Stream<Integer> stream3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)).stream();
        System.out.println(stream3.reduce((x, y) -> x + y).get());


//      3-4. forEach - 1~9 중 5를 집어와서 foreach로 출력ㄴ
        System.out.println("== forEach == ");
        IntStream.range(1, 10).filter(n -> n == 5).forEach(System.out::println);


    }
}


