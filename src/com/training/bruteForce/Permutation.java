package com.training.bruteForce;

public class Permutation {
    /*완전탐색
    * 순열(Permutation)
    * 선택순서가 결과에 영향을 미치는 경우
    * 조합(Combination)
    * 선택순서가 결과에 영향을 미치지 않는 경우
    *
    * ex)
    * ## {1, 2, 3, 4}숫자가 주어진 경우
    * ## 만들수 있 가장 큰 두자 수를 구하라(순열로 문제풀이)
    * */
    static int n = 4;
    static int[] nums = {1, 2, 3, 4};

    public static void main(String[] args){


        System.out.println(solve(0, 0, 0));
        //System.out.println(solution(n, nums));
    }

    //가장 큰 두자릿수 구하기
    public static int solve(int cnt, int used, int val){
        if(cnt == 2) return val;
//System.out.println("cnt ::> "+cnt+" used ::> "+used+" val ::> "+val);
        int ret = 0;
        for(int i = 0; i < n; i++){
            if((used & 1 << i) != 0) continue;
            ret = Math.max(ret, solve(cnt +1, used | 1 << i, val * 10 +nums[i]));
        }
        return ret;
    }

}
