package com.training.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class FirstSearch {

    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];

    public static void main(String[] args){

        N = 5;
        E = 6;
        int[] value = {0, 1, 0, 2, 1, 3, 1, 4, 2, 4, 3, 4};

        for(int i = 0; i < value.length; i += (value.length/E) ){
            int u = value[i];
            int v = value[i+1];

            Graph[u][v] = Graph[v][u] = 1;
        }
        bfs(0);
    }

    /*
    * Queue(https://gmlwjd9405.github.io/2018/08/02/data-structure-queue.html)
    * 먼저 집어 넣은 데이터가 먼저 나오는 FIFO(First In First Out)자료구조
    * add(item) : item을 리스트의 끝부분에 추가한다.
    * remove() : 리스트의 첫 번째 항목을 제거 한다.
    * peek() : 큐에서 가장 위에 있는 항목을 반환한다.
    * isEmpty() : 큐가 비어 있을 때에 true를 반환한다.
    * 주의 -> 큐에서 처음과 마지막 노드를 갱신할 때 실수가 나오기 쉽다.
    * */
    public static void bfs(int node){

        boolean[] visitied = new boolean[MAX_N];

        Queue<Integer> myqueue = new LinkedList<>();
        visitied[node] = true;
        myqueue.add(node);

        while (!myqueue.isEmpty()){
            int curr = myqueue.remove();

            System.out.println(curr + " "); //실제 방뭉

            for(int next = 0; next < N; next++){
                if(!visitied[next] && Graph[curr][next] != 0){
                    visitied[next] = true;
                    myqueue.add(next);
                }
            }
        }
    }
}
