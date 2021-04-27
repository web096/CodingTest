package com.training.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPath {
    /*
    * BFS를 이용한 최단경로 구하기
    * */
    static final int MAX_N = 10; //임의의 배열값
    static int[][] D = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상하좌우로 움직이기 위한 delta값
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];

    static class Point {
        Point(int r, int c, int d){
            row = r; col = c; dist = d;
        }
        int row, col, dist; //행 / 열 / 거리
    }

    public static void main(String[] args){

        N = 5;
        int[][] value = {{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,1,1,1,0},{0,0,0,0,0}};

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Board[i][j] = value[i][j];
            }
        }

        int sRow = 0;
        int sCol = 1;
        int dRow = 4;
        int dCol = 2;

        System.out.println(bfs(sRow, sCol, dRow, dCol));
    }

    public static int bfs(int sRow, int sCol, int dRow, int dCol){

        boolean[][] visitied = new boolean[MAX_N][MAX_N];
        Queue<Point> myqueue = new LinkedList<>();

        visitied[sRow][sCol] = true;
        myqueue.add(new Point(sRow, sCol, 0));

        while (!myqueue.isEmpty()){
            Point curr = myqueue.remove();
            if(curr.row == dRow && curr.col == dCol)
                return curr.dist;

            for(int i = 0; i < 4; i++){
                int nr = curr.row +D[i][0], nc = curr.col + D[i][1];
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
                if(visitied[nr][nc]) continue;
                if(Board[nr][nc] == 1) continue;
                visitied[nr][nc] = true;
                myqueue.add(new Point(nr, nc, curr.dist +1));

            }
        }

        return -1;
    }
}
