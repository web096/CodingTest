package com.training.javaEight.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Function1 {

    /*
    * 모든 함수 공통
    * 함수형 인터페이스는 불필요한 자원 낭비를 방지한다.
    * Lazy Evaluation이란 정말 계산이 필요한 시점까지 결과값 도출을 미룬다.
    * (참조 : https://medium.com/@goinhacker/lazy-evaluation%EA%B3%BC-%EB%A9%94%EB%AA%A8%EB%A6%AC-c6789ac2173c)
    * */

    /*
    @FunctionalInterface
    Function<T,R>
    T타입을 받아 R타입으로 변형하여 리턴한다. T -> R(R apply(T t))
    같은 타입으로 반환도 가능(identity function) - 같은 타입이면서 같은값이어야 한다. 즉, 입력값의 변환없이 그냥 리턴
    * */

    public static void main(String[] args){
        /* java default
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        */
        //lambda expression
        Function<String, Integer> toInt = (s) -> Integer.parseInt(s);
        Integer numberStr = toInt.apply("10");
        System.out.println(numberStr);

        //identity function(같은 타입 같은 값 반환)
        /* java default
        Function<String, String> identity = Function.identity();
        */
        //lambda expression
        Function<String, String> identity = t -> t;
        String identityStr = identity.apply("나는 개발자");
        System.out.println(identityStr);

        //exmple Function을 이용해서 HashMap의 value를 List형태로 변환
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A",100);
        map.put("B",10000);
        map.put("C",1384000);
        map.put("D",1010);
        map.put("E",48392);

        List<String> resultList = MapIntegerToListString(map);

        resultList.forEach(System.out::println);
    }

    public static List<String> MapIntegerToListString(HashMap<String, Integer> paramMap){
        Function<HashMap<String, Integer>, List<String>> toList = (map) -> {

            List<String> list = new ArrayList<>();

            for(Map.Entry<String, Integer> fromMap : map.entrySet()){
                String value = String.valueOf(fromMap.getValue());
                list.add(value);
            }
            return list;
        };

        return toList.apply(paramMap);
    }

}
