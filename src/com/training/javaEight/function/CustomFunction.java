package com.training.javaEight.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CustomFunction {

    public static void main(String[] args){
        Println(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1+i2+i3));
        Println("내 나이는 : ", "30", "40", (message, age1, age2) -> message + age1 + "살이상 " + age2 + "살 이하다!!");
        Println("내 나이는 : ", 30, 9, (message, age1, age2) -> message + String.valueOf(age1 + age2));
    }

    private static <T1, T2 , T3> void Println(T1 t1, T2 t2, T3 t3, FunctionCustom<T1, T2, T3, String> custom){
        System.out.println(custom.apply(t1, t2, t3));
    }
}

@FunctionalInterface
interface FunctionCustom<T1, T2, T3, R>{
    R apply(T1 t1, T2 t2, T3 t3);
}