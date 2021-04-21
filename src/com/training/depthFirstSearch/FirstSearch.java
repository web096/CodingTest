package com.training.depthFirstSearch;

import java.util.Stack;

public class FirstSearch {
    /*
    * https://www.youtube.com/watch?v=0Njv04WiLV0
    * 깊이 우선 탐색
    * -그래프 순회 방법 중하나
    * -시작 노드에서 깊이가 커지는 방향으로 탐색을 진행하여 더이상 방문할 인접 노드가 없는 경우
    *  이전 노드로 돌아가서, 다시 깊이 우선탐색을 반복하게 된다.
    * */

    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];
    static boolean[] Visited = new boolean[MAX_N];

    public static void main(String[] args){

        N = 5;
        E = 6;
        int[] value = {0, 1, 0, 2, 1, 3, 1, 4, 2, 4, 3, 4};

        for(int i = 0; i < value.length; i += (value.length/E) ){
            int u = value[i];
            int v = value[i+1];

            Graph[u][v] = Graph[v][u] = 1; //연결되어 있는 값 표시
        }
        System.out.println("=====Method dfs start====");
        dfs(0);
        System.out.println("======Method dfs end=====");
        System.out.println("=====Method dfsStack start====");
        dfsStack(0);
        System.out.println("=====Method dfsStack start====");
    }

    //재귀호출
    public static void dfs(int node){
        Visited[node] = true;
        System.out.println(node+" ");

        for(int next = 0; next < N; next++){
            System.out.println("next :: "+next+" :: node : "+node+" :: Visited : "+Visited[next]+" :: Graph : "+Graph[node][next]);
            if(!Visited[next] && Graph[node][next]!=0)
                dfs(next);
        }
    }

    /*
    * Stack(https://gmlwjd9405.github.io/2018/08/03/data-structure-stack.html)
    * 한쪽 끝에서만 자료를 넣고 뺄수 있는 LIFO(Last in of first out)형식의 자료구조
    * LIFO(Last in of first out) - 가장 최근에 추가항 항목이 가장 먼저 제거된다.
    * - POP() : 스택에서 가장 위에 있는 항목을 제거한다.
    * - push(item) : item 하나를 스택의 가장 윗 부분에 추가한다.
    * - peek() : 스택의 가장 위에 있는 항목을 반환한다.
    * - empty() : 스택이 비어 있을때 true를 반환한다.
    * - search(object) : 해당 object의 위치를 반환. 해당 object가 없으면 -1을 반환한다.
    * */
    public static void dfsStack(int node){

        boolean[] visited = new boolean[MAX_N];

        Stack<Integer> mystack = new Stack<>();
        mystack.push(node);

        while(!mystack.empty()){
            int curr = mystack.pop();

            if(visited[curr]) continue; //skip

            visited[curr] = true;
            System.out.println(curr + " ");

            for(int next = 0; next < N; next++){
                System.out.println("next :: "+next+" :: curr : "+curr+" :: visited : "+visited[next]+" :: Graph : "+Graph[node][next]);
                if(!visited[next] && Graph[curr][next]!=0)
                    mystack.push(next);
            }
        }
    }
}
