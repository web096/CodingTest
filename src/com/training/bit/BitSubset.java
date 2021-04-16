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
    * */
    public static void main(String[] args){
    /*원소가 n개인 집합
    * 부분집합의 총개수 -> 1 <<n
    * n => 대상자의 배열(리스트)의 길이
    * */
        char[] data = {'A', 'B', 'C', 'D'};
        printSubSets(data, 4);

    }
    public static void printSubSets(char[] arr, int n){

        for(int i = 0; i < (1<<n);i++){ //(1 << 4) = 16
            //System.out.println("{");
            for(int j = 0; j < n; j++){
                System.out.println("j ::> "+j+" :: "+Integer.toBinaryString(1<<j));
                if((i & 1 << j) != 0){
                   // System.out.println(arr[j]+" ");
                }
            }
            //System.out.println("}");
        }

    }
}
