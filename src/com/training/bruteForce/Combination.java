package com.training.bruteForce;

public class Combination {
    /*완전탐색
     * 순열(Permutation)
     * 선택순서가 결과에 영향을 미치는 경우
     * 조합(Combination)
     * 선택순서가 결과에 영향을 미치지 않는 경우
     *
     * ex)
     * ## {1, 2, 3, 4}숫자가 주어진 경우
     * ## 두 수를 더했을 떄 가장 큰 합을 구하라(조합으로 문제풀이)
     * */
    static int n = 4;
    static int[] nums = {1, 2, 3, 4};

    public static void main(String[] args){
        System.out.println(solution(4, nums)); //비트연산
        System.out.println(solve(0, 0, 0)); //조합(재귀)
    }

    //조합(재귀)
    public static int solve(int pos, int cnt, int val){ //pos : 위치 / cnt : 선택된값의 갯수 / val : 결과값

        if(cnt == 2) return val;
        if(pos == n) return -1;

        int result = 0;
        result = Math.max(result, solve(pos+1, cnt+1, val + nums[pos]));
        result = Math.max(result, solve(pos+1, cnt, val));

        return result;
    }


    //두 수를 더했을때 가장 큰합을 구하라(비트연산)
    public static int solution(int n, int[] nums){

        int result = 0;

        for(int i = 0; i < (1 << n);i++){
            if(Integer.bitCount(i) != 2) continue;

            int sum = 0;
            for(int j = 0;j < n;j++){
                if((i & 1 << j) != 0){
                    sum += nums[j];
                }
            }
            result = Math.max(result, sum);
        }

        return result;
    }
}
