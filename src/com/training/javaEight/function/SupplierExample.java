package com.training.javaEight.function;

import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierExample {
    /*
    @FunctionalInterface
    Supplier<T>
    T형의 값을 반환한다.(T get())
    불필요한 자원 낭비가 없다.
    * */

    public static void main(String[] args){

        /* Java Defalut
        Supplier<String> helloSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello!!";
            }
        };
        */

        //lambda expression
        Supplier<String> helloSupplier = () -> "안녕!!";

        System.out.println(helloSupplier.get()+ " Java!!!");
        System.out.println(helloSupplier.get()+ " 라이언!!!");
        System.out.println(helloSupplier.get()+ " 카카오!!!");

        //example - 성능적인 차기가 발생한다.
        //일반적인 사용 : 9초가 걸린다.
        long startNormal = System.currentTimeMillis();
        pringIfValidIndexOfNormal(-1, getPrintCommonValue());
        pringIfValidIndexOfNormal(5, getPrintCommonValue());
        pringIfValidIndexOfNormal(-3, getPrintCommonValue());
        long endNormal = System.currentTimeMillis();
        System.out.println("normal processer is secends : "+((endNormal-startNormal)/1000));

        //Supplier 사용 : 3초가 걸린다.
        long startSupplier = System.currentTimeMillis();
        pringIfValidIndexOfSupplier(-1, () -> getPrintCommonValue());
        pringIfValidIndexOfSupplier(5, () -> getPrintCommonValue());
        pringIfValidIndexOfSupplier(-3, () -> getPrintCommonValue());
        long endSupplier = System.currentTimeMillis();
        System.out.println("processer is secends : "+((endSupplier-startSupplier)/1000));

    }

    private static String getPrintCommonValue(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "아주 좋아!!";
    }

    private static void pringIfValidIndexOfNormal(int number, String value){
        if(number > 0){
            System.out.println("Lion "+value);
        }else{
            System.out.println("Invalid");
        }
    }

    private static void pringIfValidIndexOfSupplier(int number, Supplier<String> value){
        if(number > 0){
            System.out.println("이상훈 "+value.get());
        }else{
            System.out.println("Invalid");
        }
    }
}
