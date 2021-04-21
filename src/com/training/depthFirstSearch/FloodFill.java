package com.training.depthFirstSearch;

import java.util.Stack;

public class FloodFill {
    /*
    * DFS 활용(stack이용)
    *
    * */
    static final int MAX_N = 10; //배열의 크기
    static int[][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}}; //상하좌우 delta value
    static int N; //입력값의 크기(5 * 5의 이차원배열)
    static int[][] Board = new int[MAX_N][MAX_N]; //이차원배열 선언
    static class Point { //좌표
        Point(int r, int c) { row = r; col = c;}
        int row, col;
    }

    public static void main(String[] args){
        int[][] value = {{0,0,0,0,0},{0,0,0,1,1},{0,0,0,1,0},{1,1,1,1,0},{0,0,0,0,0}};

        N = 5;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Board[i][j] = value[i][j];
            }
        }

        int sRow = 1;
        int sCol = 1;
        int color = 3;

        dfs(sRow, sCol, color);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.println(Board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int r, int c, int color){
        boolean[][] visited = new boolean[MAX_N][MAX_N];
        Stack<Point> mystack = new Stack<>();
        mystack.push(new Point(r, c));

        while (!mystack.empty()){
            Point curr = mystack.pop();
            if(visited[curr.row][curr.col]) continue;

            visited[curr.row][curr.col] = true;
            Board[curr.row][curr.col] = color;

            for(int i = 0; i < 4; i++){
                int nr = curr.row + D[i][0], nc = curr.col + D[i][1];
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
                if(visited[nr][nc]) continue;
                if(Board[nr][nc] == 1) continue;
                mystack.push(new Point(nr, nc));
            }
        }
    }
}
