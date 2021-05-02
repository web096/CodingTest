package com.training.programmers.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {

    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int moveTime = solution(bridge_length, weight, truck_weights);

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList();

        for(int i = 0; i < bridge_length;i++){
            queue.add(0);
        }

        int currentWeight = truck_weights[0];
        queue.add(currentWeight);
        int currentSecend = 1; //다리위에 첫번째 트럭이 올라가 있기 때문에 1초가 사용됐다.
        int nextIndex = 1; //다리위에 첫번째 트럭이 올라가 있기 때문에 nextIndex는 다음 index를 표시해준다.
System.out.println(queue.size());

        while (!queue.isEmpty()){

            int truck = queue.poll();
            currentWeight -= truck;


        }

        return answer;
    }

}
