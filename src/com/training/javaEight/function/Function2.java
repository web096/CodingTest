package com.training.javaEight.function;

import java.util.function.Consumer;

public class Function2 {

    /*
    @FunctionalInterface
    Consumer<T>
    T타입의 값을 받아서 return을 하지 않는다.(void accept(t))
    * */

    public static void main(String[] args){

        /* java default
        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        */
        //lambda expression
        Consumer<String> print = s -> System.out.println(s);
        Consumer<String> greetings = s-> System.out.println(s + " 맞아!! 넌 잘할꺼야!!");
        print.accept("나는 물경력 개발자가 아니다.");
        greetings.accept("나는 물경력 개발자가 아니다.");
    }
}
