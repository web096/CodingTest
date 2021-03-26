package com.training.programmers.StackAndQueue;

public class Stock {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        int[] results = solution(prices);
        for(int result : results) {
            System.out.println(result);
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i =0; i < prices.length; i++) {
            int result = 0;
            for(int j = i+1; j < prices.length; j++) {
                if(prices[i] <= prices[j]) {
                    result++;
                }else {
                    result += 1;
                    break;
                }
            }

            answer[i] = result;
        }

        return answer;
    }

}
