package com.training.kakao2021;

public class TaxiLowPrice {
    /*
     * 지점 개수 n은 3 이상 200 이하인 자연수입니다.
     * 지점 s, a, b는 1 이상 n 이하인 자연수이며, 각기 서로 다른 값입니다.
     * 즉, 출발 지점, A의 도착지점, B의 도착지점은 서로 겹치지 않습니다.
     * fares는 2차원 정수 배열입니다.
     * fares 배열의 크기는 2 이상 n x (n-1) / 2 이하입니다.
     * 예를 들어, n = 6이라면 fares 배열의 크기는 2 이상 15 이하입니다. (6 x 5 / 2 = 15)
     * fares 배열의 각 행은 [c, d, f] 형태입니다.
     * c 지점과 d 지점 사이의 예상 택시요금이 f 원이라는 뜻입니다.
     * 지점 c, d는 1 이상 n 이하인 자연수이며, 각기 서로 다른 값입니다.
     * 요금 f는 1 이상 100,000 이하인 자연수입니다.
     * fares 배열에 두 지점 간 예상 택시요금은 1개만 주어집니다. 즉, [c, d, f]가 있다면 [d, c, f]는 주어지지 않습니다.
     * 출발 지점 s에서 도착지점 a와 b로 가는 경로가 존재하는 경우만 입력으로 주어집니다.
     */

    static int[][] Dist = new int[200][200];
    private static final int INF = 4000000;//초기화값 가중치

    public static void main(String args[]){

        int n = 6; //경유지갯수
        int s = 4; //줄발지점
        int a = 6; //목적지1
        int b = 2; //목적지2
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}; // 경유지별 비용 구조{지점1, 지점2, 비용}

        int price = solution(n, s, a, b, fares);
        System.out.println(price);

    }

    public static int solution(int n, int s, int a, int b, int[][] fares){ //n : 지점갯수 / s : 출발지점 / a : 목적지1 / b : 목적지2 / fares(간선)
        /*
         * TODO https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/ 4번 합승택시요금
         * 완전탐색(참조 : https://rebro.kr/59)
         * 플로이드 와샬(Floyd Warshall) 알고리즘(참조 : https://blog.naver.com/ndb796/221234427842)
         */
        //출발점과 도착점이 같으면 0 / 아니면 무한대
        for(int i = 0; i < n;i++){ //출발
            for(int j = 0; j < n; j++){ //도착
                if(i == j){
                    Dist[i][j] = 0;
                }else{
                    Dist[i][j] = INF;
                }
            }
        }

        //지점별 비용 정리
        for(int[] edge : fares){
            Dist[edge[0]-1][edge[1]-1] = edge[2];
            Dist[edge[1]-1][edge[2]-1] = edge[2];
        }

        floyd(n); //모든 경로의 비용계산

        s--;
        a--;
        b--;

        int answer = INF;

        //경유지(합승해서 갈 지점 : k) 비용 비교
        for(int k = 0; k < n; k++){
            answer = Math.min(answer, Dist[s][k] + Dist[k][a] + Dist[k][b]); //출발지점에서 경유지까지 가는 비용 + 경유지에서 목적지1까지 가는 비용 + 경유지에서 목적지2까지 가는 비용의 최소값
        }

        return answer;
    }

    public static void floyd(int n){
        for(int k = 0; k < n; k++){ //경유지
            for(int i = 0; i < n; i++){//시작점
                for(int j = 0; j < n; j++){ //도착점
                    //i에서 j를 거쳐 k로 갈때, i에서 j로 갈떄보다 비용이 작다면
                    if(Dist[i][k] + Dist[k][j] < Dist[i][j]){
                        Dist[i][j] = Dist[i][k] + Dist[k][j];
                    }
                }
            }
        }
    }

}
