package com.training.programmers.StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProgressesAndSpeeds {

    public static void main(String[] args) {

        //int[] progresses = {93,30,55};
        //int[] speeds = {1,30,5};
        int[] progresses = {40, 93, 30, 55, 60, 65};
        int[] speeds = {60, 1, 30, 5 , 10, 7};

        int[] result = solution(progresses, speeds);

        for(int ii = 0; ii < result.length;ii++) {
            System.out.println(result[ii]);
        }

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int baseValue = 0;
        int	jobCount = 0;

        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> dayList = new ArrayList<Integer>();

        for(int i = 0; i < progresses.length; i++) {
            dayList.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1:0));
            System.out.println((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1:0));
        }

        for(int remainDay : dayList) {

            System.out.println("::> "+remainDay+" :: "+baseValue+" :: "+(remainDay < baseValue));

            if(remainDay <= baseValue) {
                stack.pop();
                jobCount += 1;
                stack.push(jobCount);
            }else {
                jobCount = 1;
                stack.push(jobCount);
            }

            if(baseValue < remainDay)
                baseValue = remainDay;
        }

        if(stack.size() > 0) {
            answer = new int[stack.size()];

            for(int j = stack.size(); j > 0; j--) {
                answer[j-1] = stack.pop();
            }
        }

        return answer;
    }
}
