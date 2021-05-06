package com.training.programmers.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {

    public static void main(String[] args) {

//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int moveTime = solution(bridge_length, weight, truck_weights);
        System.out.println("result ::> "+moveTime);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList();

        for(int i = 0; i < bridge_length-1;i++){
            queue.add(0);
        }

        int currentWeight = truck_weights[0];
        queue.add(currentWeight);
        int answer = 1; //다리위에 첫번째 트럭이 올라가는 동안에는 시간을 사용하지 않는다.
        int nextIndex = 1; //다리위에 첫번째 트럭이 올라가 있기 때문에 nextIndex는 다음 index를 표시해준다.
        int goalTruck = 0;

        while (!queue.isEmpty()){

            int truck = queue.poll();
            currentWeight -= truck;
            answer += 1;

            int nextWeights = 0;
            if(nextIndex < truck_weights.length){
                nextWeights = truck_weights[nextIndex];
            }

//System.out.println("truck ::> "+truck+" currentWeight ::> "+currentWeight+" currentSecend ::> "+currentSecend);
            if(currentWeight + nextWeights <= weight){
                queue.add(nextWeights);
                currentWeight += nextWeights;
                nextIndex += 1;
//System.out.println("nextIndex ::> "+nextIndex+" currentWeight ::> "+currentWeight+" nextWeights ::> "+nextWeights);
            }else{
                queue.add(0);
            }

            if(truck > 0){
                goalTruck += 1;
System.out.println("도착한 트럭 : "+goalTruck);
                if(goalTruck == truck_weights.length){
                    queue.clear();
                }
            }
        }

        return answer;
    }

}
