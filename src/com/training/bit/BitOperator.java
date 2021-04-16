package com.training.bit;

public class BitOperator {
    //비트는 0,1의 값만 가진다. 즉, 2의 n승의 값을 가진다.
    public static void main(String[] args){

        /*
        * 비트 연산자 &(AND) 두 비트가 모두 1일 경우에만 1을 반환
        * 3(00000011) & 6(00000110) = 2(00000010)
        * */
        int a = 3 & 6; System.out.println("& => "+a);

        /*
         * 비트 연산자 |(OR) 두 비트중 하나라도 1이면 1을 반환
         * 3(00000011) | 6(00000110) = 7(00000111)
         * */
        int b = 3 | 6; System.out.println("| => "+b);

        /*
         * 비트 연산자 ^(XOR) 두 비트가 같으면 0, 다르면 1을 반환
         * 3(00000011) ^ 6(00000110) = 5(00000101)
         * */
        int c = 3 ^ 6; System.out.println("^ => "+c);
        /* XOR의 특성은 x ^ y에 다시 ^ y or ^ x를 해주면 x or y의 값으로 돌아온다.
        * */
        int d = c ^ 6; System.out.println("c ^ => "+d);

        /* 비트 연산자 ~(NOT) 각 비트를 반전, 0이면 1, 1이면 0 */
        int x1 = 9;
        System.out.println("bit binary xor start : "+Integer.toBinaryString(x1));
        int e = ~x1; System.out.println("~ => "+e);
        System.out.println("bit binary xor end : "+Integer.toBinaryString(e));

        /* 비트 연산자 <<(Left shift) 비트를 왼쪽으로 이동(왼쪽으로 이동할때마다 곱하기 2) */
        int x2 = 1;
        System.out.println("bit binary left shift start : "+Integer.toBinaryString(x2));
        int f = x2 << 2; System.out.println("<< => "+f);
        System.out.println("bit binary left shift end : "+Integer.toBinaryString(f));

        /* 비트 연산자 >>(right shift) 비트를 오른쪽쪽으로 이동(오른쪽으로 이동할때마다 나누기 2) */
        System.out.println("bit binary right shift start : "+Integer.toBinaryString(f));
        int g = f >> 2; System.out.println(">> => "+g);
        System.out.println("bit binary right shift end : "+Integer.toBinaryString(g));
    }
}
