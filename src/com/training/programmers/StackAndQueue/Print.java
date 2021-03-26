package com.training.programmers.StackAndQueue;

import java.util.LinkedList;

public class Print {

    public static void main(String[] args) {

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        //int[] priorities = {3, 3, 4, 2};
        //int location = 3;

        int answer = solution(priorities, location);
        System.out.println("answer :::> "+answer);

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        LinkedList<PrintStandBy> printQueue = new LinkedList<>();
        LinkedList<PrintStandBy> outQueue = new LinkedList<>();

        for(int i = 0;i < priorities.length; i++) {
            printQueue.offer(new PrintStandBy(i, priorities[i]));
        }

        while(printQueue.size() > 0) {

            boolean out = false;
            PrintStandBy printStendBy = printQueue.getFirst();


            for(int j=0; j < printQueue.size(); j++) {

                if(printStendBy.priorities < printQueue.get(j).priorities) {
                    printQueue.addLast(printStendBy);
                    printQueue.removeFirst();
                    out = false;
                    break;
                }else {
                    out = true;
                }
            }

            if(out) {
                outQueue.addLast(printStendBy);
                printQueue.remove(printStendBy);
            }

            if(printStendBy.idx == location) {
                answer = outQueue.indexOf(printStendBy)+1;
            }
        }

        outQueue.stream().forEach(print ->{
            System.out.println("final ::> "+print.idx+" :: "+print.priorities);
        });

        return answer;
    }
}

class PrintStandBy {
    int idx;
    int priorities;

    PrintStandBy(int idx, int priorities){
        this.idx = idx;
        this.priorities = priorities;
    };
}
