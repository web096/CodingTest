package com.training.javaEight.function;

import java.math.BigDecimal;

public class CustomFunction {



    public static void main(String[] args){
        Println(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1+i2+i3));
        Println("내 나이는 : ", "30", "40", (message, age1, age2) -> message + age1 + "살이상 " + age2 + "살 이하다!!");
        Println("내 나이는 : ", 30, 9, (message, age1, age2) -> message + String.valueOf(age1 + age2));

        BigDecimalToCurrency bigDecimalToCurrency = s -> "$" + s.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));

        /*
         * FunctionalInterface 생성시 아래와 같이 제네릭 <T>가 사용되어 있다면 lambdaExpression을 사용하지 못한다.
         * anonymous로는 사용 가능
         * <T> value는 타입추론이 가능하지만 <T>는 s -> s.toString(); lambda형식으로 값을 받으면 타입을 추론할 수 없기 때문이다.
         * */
        InvalidFunctionalInterface anonymousInvalid = new InvalidFunctionalInterface() {
            @Override
            public <T> String mkString(T value) {
                return value.toString();
            }
        };
        System.out.println(anonymousInvalid.mkString(12345));

    }

    private static <T1, T2 , T3> void Println(T1 t1, T2 t2, T3 t3, FunctionCustom<T1, T2, T3, String> custom){
        System.out.println(custom.apply(t1, t2, t3));
    }
}

@FunctionalInterface
interface FunctionCustom<T1, T2, T3, R>{
    R apply(T1 t1, T2 t2, T3 t3);
}

@FunctionalInterface
interface BigDecimalToCurrency{
    String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionalInterface{
    <T> String mkString(T value);
}