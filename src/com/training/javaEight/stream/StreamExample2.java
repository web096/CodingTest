package com.training.javaEight.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample2 {
    public static void main(String[] args) {
        System.out.println("collect(toList()) : " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(Collectors.toList())
        );

        System.out.println("collect(toSet()) : " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(Collectors.toSet()) //set은 중복 안됨
        );

        System.out.println("collect(joining()) : " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(Collectors.joining(", ", "[", "]"))
        );

        System.out.println("collect(joining()) : " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(Collectors.joining(", ", "[", "]"))
        );

        System.out.println("collect(toList()) : " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(Collectors.toList())
        );

        //Integer의 max값은 127이다. 127이상의 값을 ==로 찾는다면 값을 찾을수가 없다.
        final Integer integer3 = 3;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5) //compiler에서 auto boxing이 발생하여 Integer로 변경한다.
                        .filter(i -> i == integer3) //Equality가 아니라 Identity를 확인 / Equality : equals()를 이용해 확인 / Identity : == 이용해 메모리 레퍼런스 확인
                        .findFirst()
        );

        //127이상의 값을 찾을려면 equals를 사용한다.
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128) //compiler에서 auto boxing이 발생하여 Integer로 변경한다.
                        .filter(i -> i.equals(128)) //Equality가 아니라 Identity를 확인 / Equality : equals()를 이용해 확인 / Identity : == 이용해 메모리 레퍼런스 확인
                        .findFirst()
        );

        System.out.println(".filter(i -> i > integer3).count() : " +
                Stream.of(1, 2, 3, 4, 5, 128)
                        .filter(i -> i > integer3)
                        .count()
        );
    }
}

