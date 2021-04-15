package com.training.javaEight.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Function3 {

    /*
    @FunctionalInterface
    Predicate<T>
    T타입의 값을 받아서 boolean으로 반환한다.(t -> boolean(boolean test(t))
    * */

    public static void main(String[] args){

        /* java default
        Predicate<Integer> isInt = new Predicate<Integer>() {
            @Override
            public boolean test(Integer s) {
                return s > 50;
            }
        };
        */
        //lambda expression
        Predicate<Integer> isInt = i -> i > 50;

        boolean result1 = isInt.test(20);
        System.out.println(result1);
        boolean result2 = isInt.test(100);
        System.out.println(result2);


        //example
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(isExp(list, i -> i < 7));
        System.out.println(isExp(list, i -> i <= 9));
        System.out.println(isExp(list, i -> i < 2));

    }

    private static <T> List<T> isExp(List<T> list, Predicate<T> filter){

        List<T> result = new ArrayList<>();

        for(T t : list){
            if(filter.test(t)){
                result.add(t);
            }
        }
        return result;
    }

}
