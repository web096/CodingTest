package com.training.programmers.StackAndQueue;

import java.util.Stack;

public class Tower {
    public static void main(String[] args) {

        int[] heights = {10,2,4,3,9};

        int[] k = solution(heights);

    }

    public static int[] solution(int[] heights) {

        Stack<Integer> st = new Stack<>();

        int[] answer = new int[heights.length];

        for(int i=0;i<heights.length;i++) {

            st.push(heights[i]);

        }


        while(!st.isEmpty()) {
            int height = st.pop();

            for(int j=heights.length; j >= 0;j--) {

                if(height < heights[j-1]) {
                    System.out.println(heights.length+" :: "+(j-1));
                    answer[j-1] = heights[j-1];
                    break;
                }
            }

        }

        return answer;
    }

}