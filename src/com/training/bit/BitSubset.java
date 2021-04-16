package com.training.bit;

public class BitSubset {
    /*
    * 비트를 이용한 부분 집합
    * 십진수 : 이진수 : {A,B,C,D}
    *   0   :  0000  :    {}
    *   1   :  0001  :   {A}
    *   2   :  0010  :   {B}
    *   3   :  0011  :   {A,B}
    *   4   :  0100  :   {C}
    *   5   :  0101  :   {A,C}
    *   6   :  0110  :   {B,C}
    *   7   :  0111  :   {A,B,C}
    *   8   :  1000  :   {D}
    *   9   :  1001  :   {A,D}
    *  10   :  1010  :   {B,D}
    *  11   :  1011  :   {A,B,D}
    *  12   :  1100  :   {C,D}
    *  13   :  1101  :   {A,C,D}
    *  14   :  1110  :   {B,C,D}
    *  15   :  1111  :   {A,B,C,D}
    *
    * 비트연산의 활용
    * # i번째 원소가 있는지 확인
    * ## (비트로 표현된 집합) & (1 << i) 결과가 0이 아니면 존재
    * ## ex) 2번째 원소가 있는지 확인
    *    0101 & (1 << 2) = 0101 & 0100 = 0100
    *    (1 << 2) 의 의미는 1(0001)의 제일 앞에 있는 1을 기준으로 왼쪽으로 두번 옮긴다라는 뜻이다. 즉, 0100이 된다.
    *    (3 << 2) 의 의미는 3(0011)이므로 제일 앞에 있는 1을 기준으로 왼쪽으로 두번 옮기면 1100(12)가 된다.
    * # i번째 원소를 추가
    * ## (비트로 표현된 집합) | (1<<i)
    * ## ex) 1번째 원소를 추가
    *    0101 | (1 << 1) = 0101 | 0010 = 0111
    * # i번째 원소를 삭제
    * ## (비트로 표현된 집합) & ~(1<<i)
    * ## ex) 2번째 원소를 삭제
    *    0101 & ~(1<<2) = 0101 & ~(0100) => 0101 & 1011 = 0001
    *
    * 집합의 원소 개수(비트값이 1인 개수)
    * # Integer.bitCount(int i) 메소드 사용
    *
    * 연습문제(두수의 합이 7인 경우의 수)
    * ## exmple 메소드 참조
    * ## 입력값
    *    6
    *    1 2 3 4 5 6
    * */
    public static void main(String[] args){
    /*원소가 n개인 집합
    * 부분집합의 총개수 -> 1 <<n
    * n => 대상자의 배열(리스트)의 길이
    * */
        char[] data = {'A', 'B', 'C', 'D'};
        //printSubSets(data, 4);

        //exmple
        int n = 6;
        int[] arr = {1, 2, 3, 4, 5, 6};
        exmple(n, arr);
    }
    public static void printSubSets(char[] arr, int n){

        for(int i = 0; i < (1<<n);i++){ //(1 << 4) = 16 경우의 수
            //System.out.println("{");
            for(int j = 0; j < n; j++){
                System.out.println("j ::> "+j+" :: "+(i & 1 << j));
                if((i & 1 << j) != 0){ // 부분집합
                    System.out.println(i+" :: "+arr[j]+" ");
                }
            }
            //System.out.println("}");
        }
    }

    public static void exmple(int n, int[] arr){
        int result = 0;
        for(int i = 0; i < (1<<n); i++){ // 경우의 수
            /*
            6개의 비트 안에 켜져 있는(1) 값만 sum한다.
            {1, 2, 3, 4, 5, 6}
            100010이라면 1+5 = 6
            비트는 위치값(인덱스값)으로 생각하면 된다.
            */
            if(Integer.bitCount(i) != 2){ //제약 조건이 두수의 합이 므로 비트값 1이 2개가 아닌것들은 제외한다.
                continue;
            }

            int sum = 0;
            for(int j = 0;j < n; j++){
               if((i & 1<<j) != 0){ //부분집합
                    sum += arr[j];
               }
            }
            System.out.println(i+" :: "+sum);
            if(sum == 7){
                result += 1;
            }
        }
        System.out.println("두수의 합이 7인 경우의 수는 ::> "+result+"개");
    }
}
