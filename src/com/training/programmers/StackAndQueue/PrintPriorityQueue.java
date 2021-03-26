package com.training.programmers.StackAndQueue;

import java.util.PriorityQueue;

public class PrintPriorityQueue {
    /*
     * PriorityQueue 순차정렬 Queue
     */
    public static void main(String[] args) {

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = solution(priorities, location);
        System.out.println("answer :::> "+answer);

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<PrintStandByComparable> printQueue = new PriorityQueue<>();

        for(int i = 0;i < priorities.length; i++) {
            printQueue.offer(new PrintStandByComparable(i, priorities[i]));
        }

        while(!printQueue.isEmpty()) {
            answer++;
            PrintStandByComparable printStendByComparable = printQueue.poll();

            System.out.println(printStendByComparable.idx+ " :: " +printStendByComparable.priorities);

            if(printStendByComparable.idx == location) {
                //break;
            }
        }

        return answer;
    }
}

class PrintStandByComparable implements Comparable<PrintStandByComparable> {
    int idx;
    int priorities;

    PrintStandByComparable(int idx, int priorities){
        this.idx = idx;
        this.priorities = priorities;
    };

    public int compareTo(PrintStandByComparable target) {
        return this.priorities <= target.priorities ? 1 : - 1;
    }
}