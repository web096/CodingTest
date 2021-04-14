package com.training.javaEight.function;

import java.util.function.Function;

public class Function1 {

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

    }

}
