package com.training.javaEight.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {
    /*
    * Stream : 일종의 Coullection Build라고 볼 수 있다.
    * Stream은 게으르다(Lazy) 결과값을 달라고 하기 전까지 동작을 하지 않는다.
    * Intermediate Operation Method는 Stream을 리천하기 떄문에 계속 Method Chaining을 통해서 무엇을 해야할지 스트림에게 지시할 수 있다.
    * - filter / map 등
    * Terminal Operation Method 는 결과값을 처리한다.
    * */
    public static void main(String[] args){
        //IntStream.rangeClosed(0, 10).forEach(i -> System.out.println(i + " "));
        //Stream.iterate(1, i -> i +1).forEach(System.out::println); //무한 Collection

        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final List<Integer> result = new ArrayList<>();
        for (final Integer number : numbers) {
            if(number > 3 && number < 9){
                final Integer newNumber = number * 2;
                result.add(newNumber);
            }
        }
        System.out.println("Imperative Result : "+result);

        //Stream 동작확인
        //결과값이 없을 수도 있기 때문에 Optional로 반환
        System.out.println("Funtional Result : " +
        numbers.stream().filter(number -> {
                    System.out.println("number > 3");
                    return number > 3;
                })
                .filter(number -> {
                    System.out.println("number < 9");
                    return number < 9;})
                .map(number -> {
                    System.out.println("number * 2");
                    return number * 2;})
                .filter(number -> {
                    System.out.println("number > 10");
                    return number > 10;
                })
                .findFirst()
        );
    }
}
